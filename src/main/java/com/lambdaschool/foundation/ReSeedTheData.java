package com.lambdaschool.foundation;

import com.lambdaschool.foundation.dtos.CityInfo;
import com.lambdaschool.foundation.dtos.DataSeeder;
import com.lambdaschool.foundation.models.*;
import com.lambdaschool.foundation.services.*;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.configurers.UrlAuthorizationConfigurer;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Transactional
@Component
public class ReSeedTheData implements CommandLineRunner {

    @Autowired
    CityService cityService;

    @Autowired
    ZipcodeService zipcodeService;

    @Autowired
    HistoricalCovidService historicalCovidService;

    @Autowired
    HistoricalHousingService historicalHousingService;

    @Autowired
    HistoricalIncomeService historicalIncomeService;

    @Autowired
    HistoricalWeatherService historicalWeatherService;

    @Autowired
    CountyService countyService;

    public class DataSeederListClass {
        private List<DataSeeder> cities = new ArrayList<>();

        public DataSeederListClass() {
        }

        public List<DataSeeder> getCities() {
            return cities;
        }

        public void setCities(List<DataSeeder> cities) {
            this.cities = cities;
        }
    }

    @Override
    public void run(String... args) throws Exception {
        URL baseUrl = new URL("https://labs27-c-citrics-api.herokuapp.com/cities/allid");
        var connection = (HttpURLConnection) baseUrl.openConnection();
        connection.setRequestMethod(HttpMethod.GET.name());

        var stream = connection.getInputStream();
        ObjectMapper mapper = new ObjectMapper();
        var cities = mapper.readValue(stream, CityInfo[].class);
        var count = 1;
        for(var city : cities)
        {
            URL getUrl = new URL(String.format("https://labs27-c-citrics-api.herokuapp.com/cities/city/%d", city.getCityid()));
            var getUrlConnection = (HttpURLConnection) getUrl.openConnection();
            getUrlConnection.setRequestMethod(HttpMethod.GET.name());
            var getStream = getUrlConnection.getInputStream();

            ObjectMapper getMapper = new ObjectMapper();
            var seeder = getMapper.readValue(getStream, DataSeeder.class);
            System.out.println(String.format("Finished %d", count));

            City newCity = new City();

            newCity.setAverageage(seeder.getAverageage());
            newCity.setAveragehouse(seeder.getAveragehouse());
            newCity.setAverageperc(seeder.getAverageperc());
            newCity.setAveragetemp(seeder.getAveragetemp());
            newCity.setAvgnewcovidcases(seeder.getAvgnewcovidcases());
            newCity.setCitynamestate(seeder.getCitynamestate());
            newCity.setCostoflivingindex(seeder.getCostoflivingindex());
            newCity.setDensitykmsq(seeder.getDensitykmsq());
            newCity.setDensitymisq(seeder.getDensitymisq());
            newCity.setHouseholdincome(seeder.getHouseholdincome());
            newCity.setIndividualincome(seeder.getIndividualincome());
            newCity.setLatitude(seeder.getLatitude());
            newCity.setLogitude(seeder.getLogitude());
            newCity.setPopulation(seeder.getPopulation());
            newCity.setRent(seeder.getRent());
            newCity.setAcastatus(seeder.getAcastatus());
            newCity.setFpis(seeder.getFpis());
            newCity.setStatecode(seeder.getStatecode());
            newCity.setTimezone(seeder.getTimezone());
            newCity.setWebsite(seeder.getWebsite());
            newCity.setWikiimgurl(seeder.getWikiimgurl());
            newCity.setGnis(seeder.getGnis());
            newCity = cityService.save(newCity);
            for(var county : seeder.getCounties())
            {
                var c = new County();
                c.setCity(newCity);
                c.setName(county.getName());
                newCity.getCounties().add(c);
            }
            for(var covid : seeder.getCovid())
            {
                var vid = new HistoricalCovid();
                vid.setCases(covid.getCases());
                vid.setCity(newCity);
                vid.setDay(covid.getDay());
                vid.setMonth(covid.getMonth());
                vid.setYear(covid.getYear());
                newCity.getCovid().add(vid);
            }
            for(var house : seeder.getHistoricalaveragehouse())
            {
                var avgHouse = new HistoricalHousing();
                avgHouse.setCity(newCity);
                avgHouse.setHousingcost(house.getHousingcost());
                avgHouse.setMonth(house.getMonth());
                avgHouse.setYear(house.getYear());
                newCity.getHistoricalaveragehouse().add(avgHouse);
            }
            for(var income : seeder.getHistoricalincome())
            {
                var i = new HistoricalIncome();
                i.setCity(newCity);
                i.setHouseholdincome(income.getHouseholdincome());
                i.setIndividualincome(income.getIndividualincome());
                i.setYear(income.getYear());
                newCity.getHistoricalincome().add(i);
            }
            for(var weather : seeder.getHistoricalweather())
            {
                var w = new HistoricalWeather();
                w.setCity(newCity);
                w.setMonth(weather.getMonth());
                w.setPrecipitation(weather.getPrecipitation());
                w.setTemperature(weather.getTemperature());
                newCity.getHistoricalweather().add(w);
            }
            for(var pop : seeder.getPopulationhist())
            {
                var pHis = new PopulationHist();
                pHis.setCity(newCity);
                pHis.setPop(pop.getPop());
                pHis.setYear(pop.getYear());
                newCity.getPopulationhist().add(pHis);
            }
            // TODO: use regular expressions to "clean" the zip codes coming from the old database
            for(var zip : seeder.getZipcodes())
            {
                String code = zip.getCode();
                Pattern p = Pattern.compile("(\\d{1,5}\\D?\\d{1,5})");
                Matcher m = p.matcher(code);
                if(m.find())
                {
                    var z = new Zipcode();
                    z.setCity(newCity);
                    z.setCode(m.group());
                    newCity.getZipcodes().add(z);
                }
            }
            cityService.save(newCity);

            count++;
            if(count > 30)
            {
                return;
            }
        }
    }
}
