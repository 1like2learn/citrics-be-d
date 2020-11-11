package com.lambdaschool.foundation.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lambdaschool.foundation.dtos.CityUpdater;
import com.lambdaschool.foundation.exceptions.ResourceNotFoundException;
import com.lambdaschool.foundation.models.*;
import com.lambdaschool.foundation.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;

@Transactional
@Service(value = "cityService")
public class CityServiceImpl implements CityService
{
    /**
     * Connections to needed repositories
     */
    @Autowired
    private CityRepository cityrepo;

    @Autowired
    private ZipcodeRepository ziprepo;

    @Autowired
    private CountyRepository countrepo;

    @Autowired
    private PopulationHistRepository poprepo;

    @Autowired
    private HistoricalIncomeRepository increpo;

    @Autowired
    private HistoricalHousingRepository housrepo;

    @Autowired
    private HistoricalCovidRepository covrepo;

    @Autowired
    private HistoricalWeatherRepository wearepo;

    @Autowired
    private UserRepository userrepo;


    /**
     * Find all cities in DB
     *
     * @return list of Cities
     */
    @Override
    public List<City> findAll()
    {
        List<City> list = new ArrayList<>();

        cityrepo.findAll()
            .iterator()
            .forEachRemaining(list::add);

        return list;
    }

    /**
     * find city by cityid
     *
     * @param id local id of city
     * @return City object matching the city id or
     * @throws ResourceNotFoundException
     */
    @Override
    public City findCityById(long id) throws ResourceNotFoundException
    {
        return cityrepo.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("City id " + id + " not found!"));
    }

    /**
     * Saves new city to DB
     * Had to modify last minute to accept new city schema returned by DS
     * @param city new city to be saved
     * @return newly saved city
     */
    @Transactional
    @Override
    public City save(City city)
    {
        City c = new City();

        if (city.getCityid() != 0)
        {
            cityrepo.findById(city.getCityid())
                .orElseThrow(() -> new ResourceNotFoundException("City id " + city.getCityid() + " not found!"));
            c.setCityid(city.getCityid());
        }

        c.setCitynamestate(city.getCitynamestate());
        c.setStatecode(city.getStatecode());
        c.setTimezone(city.getTimezone());
        c.setLatitude(city.getLatitude());
        c.setLogitude(city.getLogitude());
        c.setFpis(city.getFpis());
        c.setGnis(city.getGnis());
        c.setWikiimgurl(city.getWikiimgurl());
        c.setWebsite(city.getWebsite());
        c.setPopulation(city.getPopulation());
        c.setDensitymisq(city.getDensitymisq());
        c.setDensitykmsq(city.getDensitykmsq());
        c.setAverageage(city.getAverageage());
        c.setHouseholdincome(city.getHouseholdincome());
        c.setIndividualincome(city.getIndividualincome());
        c.setAveragehouse(city.getAveragehouse());
        c.setRent(city.getRent());
        c.setCostoflivingindex(city.getCostoflivingindex());
        c.setAcastatus(city.getAcastatus());

        for (Zipcode z : city.getZipcodes())
        {
//            Zipcode zip = ziprepo.findById(z.getZipid())
//                .orElseThrow(() -> new ResourceNotFoundException("Zipcode id " + z.getZipid() + " not found!"));
            z.setCity(c);
            c.getZipcodes()
                .add(z);
        }

        for (County county : city.getCounties())
        {
            /**
             * UNCOMMENT WHEN DB IS DONE SEEDING
             * cannot find property until DB is seeded
             */
            //            County count = countrepo.findById(county.getCountyid())
//                .orElseThrow(() -> new ResourceNotFoundException("County id " + county.getCountyid() + " not found!"));
            county.setCity(c);
            c.getCounties()
                .add(county);
        }

        for (PopulationHist p : city.getPopulationhist())
        {
            /**
             * UNCOMMENT WHEN DB IS DONE SEEDING
             * cannot find property until DB is seeded
             */
//            PopulationHist pop = poprepo.findById(p.getPopid())
//                .orElseThrow(() -> new ResourceNotFoundException("Historical Population id " + p.getPopid() + " not found!"));
            p.setCity(c);
            c.getPopulationhist()
                .add(new PopulationHist(p.getYear(), p.getPop(), c));
        }

        for (HistoricalIncome i : city.getHistoricalincome())
        {
            /**
             * UNCOMMENT WHEN DB IS DONE SEEDING
             * cannot find property until DB is seeded
             */
//            HistoricalIncome inc = increpo.findById(i.getIncid())
//                .orElseThrow(() -> new ResourceNotFoundException("Historical Income id " + i.getIncid() + " not found!"));
            i.setCity(c);
            c.getHistoricalincome()
                .add(new HistoricalIncome(i.getYear(), i.getIndividualincome(), i.getHouseholdincome(), c));
        }

        for (HistoricalHousing h : city.getHistoricalaveragehouse())
        {
            /**
             * UNCOMMENT WHEN DB IS DONE SEEDING
             * cannot find property until DB is seeded
             */
//            HistoricalHousing ho = housrepo.findById(h.getHouseid())
//                .orElseThrow(() -> new ResourceNotFoundException("Historical Housing id " + h.getHouseid() + " not found!"));
            h.setCity(c);
            c.getHistoricalaveragehouse()
                .add(new HistoricalHousing(h.getYear(), h.getYear(), h.getHousingcost(), c));
        }

        for (HistoricalCovid co : city.getCovid())
        {
            /**
             * UNCOMMENT WHEN DB IS DONE SEEDING
             * cannot find property until DB is seeded
             */
//            HistoricalCovid cov = covrepo.findById(co.getCovidid())
//                .orElseThrow(() -> new ResourceNotFoundException("Historical Covid id " + co.getCovidid() + " not found!"));
            co.setCity(c);
            c.getCovid()
                .add(new HistoricalCovid(co.getYear(), co.getMonth(), co.getDay(), co.getCases(), c));
        }

        for (HistoricalWeather weather : city.getHistoricalweather())
        {
            /**
             * UNCOMMENT WHEN DB IS DONE SEEDING
             * cannot find property until DB is seeded
             */
//            HistoricalWeather h = wearepo.findById(weather.getWeatherid())
//                .orElseThrow(() -> new ResourceNotFoundException("Historical Weather id " + weather.getWeatherid() + " not found!"));
            weather.setCity(c);
            c.getHistoricalweather()
                .add(new HistoricalWeather(weather.getMonth(), weather.getPrecipitation(), weather.getTemperature(), c));
        }

        for (UserCities user : city.getUsers())
        {
            c.getUsers()
                .add(user);

        }

        c.setAveragetemp(city.getAveragetemp());
        c.setAverageperc(city.getAverageperc());
        c.setAvgnewcovidcases(city.getAvgnewcovidcases());

        return cityrepo.save(c);
    }

    /**
     * Saves new city from DS API schema
     * Had to modify last minute to accept new city schema returned by DS
     * @param city JSON City to be saved
     * @return newly saved City object
     */
    @Transactional
    @Override
    public City saveDs(DSCity city) throws Exception
    {

        /**
         * Takes DScity model and converts it to City
         */

        City c = new City();

        c.setCitynamestate(city.getCity() + ", " + city.getStatename());
        c.setStatecode(city.getAbbrev());
        c.setTimezone(city.getTimezone());
        c.setLatitude(city.getLatitude());
        c.setLogitude(city.getLongitude());
        c.setFpis(city.getFIPS());
        c.setWikiimgurl(city.getWiki_img_url());
        c.setWebsite(city.getWebsite());
        c.setPopulation(city.getPop());
        c.setDensitymisq(city.getDensity_mi_sq());
        c.setDensitykmsq(city.getDensity_km_sq());
        c.setAverageage(city.getAge());
        c.setHouseholdincome(city.getHousehold());
        c.setIndividualincome(city.getIndividual());
        c.setAveragehouse(city.getHouse());
        c.setRent(city.getRent());
        c.setCostoflivingindex(city.getCOLI());
        c.setAcastatus(city.getACA_status());

        /**
         * Splits zipcode string into
         * an actual list of strings
         */
        if (city.getZiplist() != null)
        {
            String rawZip = city.getZiplist();
            String[] split = rawZip.split(" ");

            for (String s : split)
            {
                c.getZipcodes()
                    .add(new Zipcode(s,
                        c));
            }
        }

        /**
         * Splits counties string
         * into an actual list of strings
         */
        if (city.getCounties() != null)
        {
            String rawCount = city.getCounties();
            String[] split = rawCount.split(" ");

            for (String s : split)
            {
                c.getCounties()
                    .add(new County(s,
                        c));
            }
        }

        /**
         * Splits historical population list string
         * into an actual list of historical populations
         */
        if (city.getPop_hist() != null)
        {
            DSHistoricalPop p = city.getPop_hist();

            ObjectMapper mapper = new ObjectMapper();

            String raw = mapper.writeValueAsString(p);
            raw = raw.replace("{",
                "");
            raw = raw.replace("}",
                "");
            raw = raw.replace("\"", "");
            raw = raw.replace("city:",
                "");
            raw = raw.replace(city.getCity() + ", " + city.getStatename() + ",",
                "");
            raw = raw.replace("Braintree ",
                "");
            raw = raw.replace("Town,",
                "");
            raw = raw.replace("Nashville-Davidson,",
                "");
//            raw = raw.replace(city.getStatename() + ",",
//                "");
            raw = raw.replace("POP",
                "");
            raw = raw.replace("_",
                "");
            raw = raw.replace("census",
                "");
            raw = raw.replace("est",
                "");

            raw = raw.trim();

            String[] split = raw.split(",");

            for (String s : split)
            {
                String[] splits = s.split(":");
                c.getPopulationhist()
                    .add(new PopulationHist(Integer.parseInt(splits[0]),
                        Double.parseDouble(splits[1]),
                        c));
            }

        }

        /**
         * Splits historical income string
         * into an actual list of historical incomes
         */
        if (city.getIncome_hist() != null)
        {
            DSHistoricalIncome i = city.getIncome_hist();

            ObjectMapper mapper = new ObjectMapper();

            String raw = mapper.writeValueAsString(i);
            raw = raw.replace("{",
                "");
            raw = raw.replace("}",
                "");
            raw = raw.replace("\"", "");
            raw = raw.replace("_Med",
                "");
            raw = raw.replace("_Inc",
                "");

            String[] split = raw.split(",");

            List<String> house = new ArrayList<>();
            List<String> ind = new ArrayList<>();

            for (String s : split)
            {
                if (s.contains("Hou"))
                {
                    house.add(s);
                } else if (s.contains("Ind"))
                {
                    ind.add(s);
                }
            }

            Hashtable<Integer, List<Integer>> h = new Hashtable<>();


            for (String s : house)
            {
                s = s.replace("_Hou",
                    "");
                String[] splits = s.split(":");
                int year = Integer.parseInt(splits[0]);
                int cost = Integer.parseInt(splits[1]);

                List<Integer> list = new ArrayList<>();
                list.add(cost);
                h.put(year,
                    list);
            }

            for (String s : ind)
            {
                s = s.replace("_Ind",
                    "");
                String[] splits = s.split(":");
                int year = Integer.parseInt(splits[0]);
                int cost = Integer.parseInt(splits[1]);

                List<Integer> list = h.get(year);
                list.add(cost);
            }

            Set<Integer> keys = h.keySet();

            for (Integer key : keys)
            {
                List<Integer> list = h.get(key);

                c.getHistoricalincome()
                    .add(new HistoricalIncome(key,
                        list.get(1),
                        list.get(0),
                        c));
            }

        }

        /**
         * Splits historical hosuing string
         * into an actual list of historical housing
         */
        if (city.getHome_hist() != null)
        {
            DSHistoricalHousing h = city.getHome_hist();

            ObjectMapper mapper = new ObjectMapper();

            String raw = mapper.writeValueAsString(h);

            raw = raw.replace("{",
                "");
            raw = raw.replace("}",
                "");
            raw = raw.replace("\"", "");
            String[] split = raw.split(",");

            for (String s : split)
            {
                String[] first = s.split(":");

                double cost;

                try
                {
                    cost = Double.parseDouble(first[1]);
                } catch (NumberFormatException nfe)
                {
                    cost = 0;
                }

                String[] second = first[0].split("_");

                int year = Integer.parseInt(second[0]);
                int month = Integer.parseInt(second[1]);

                c.getHistoricalaveragehouse()
                    .add(new HistoricalHousing(year,
                        month,
                        (int) cost,
                        c));
            }
        }

        /**
         * Splits historical covid string
         * into an actual list of historical covid cases
         */
        if (city.getJhcovid() != null)
        {
            DSHistoricalCovid cov = city.getJhcovid();

            ObjectMapper mapper = new ObjectMapper();

            String raw = mapper.writeValueAsString(cov);
            raw = raw.replace("{",
                "");
            raw = raw.replace("}",
                "");
            raw = raw.replace("\"", "");


            String[] split = raw.split(",");

            for (String s : split)
            {
                if (s.contains("C") || s.contains(city.getStatename()) || s.contains("U"))
                {
                    continue;
                } else
                {
                    String[] first = s.split(":");
                    int cases = (int) Double.parseDouble(first[1]);

                    String[] second = first[0].split("_");

                    int year = Integer.parseInt(second[0]);
                    int month = Integer.parseInt(second[1]);
                    int day = Integer.parseInt(second[2]);

                    c.getCovid()
                        .add(new HistoricalCovid(year,
                            month,
                            day,
                            cases,
                            c));
                }


            }
        }

        /**
         * Splits historical weather string
         * into actual list of historical weather
         */
        if (city.getWeather_hist() != null)
        {
            DSHistoricalWeather w = city.getWeather_hist();

            ObjectMapper mapper = new ObjectMapper();

            String raw = mapper.writeValueAsString(w);
            raw = raw.replace("{",
                "");
            raw = raw.replace("}",
                "");
            raw = raw.replace("\"", "");

            String[] split = raw.split(",");

            List<String> perc = new ArrayList<>();
            List<String> temp = new ArrayList<>();
            Hashtable<String, List<Double>> h = new Hashtable<>();


            for (String s : split)
            {
                if (s.contains("prec"))
                {
                    perc.add(s);
                } else if (s.contains("temp"))
                {
                    temp.add(s);
                }
            }


            for (String s : perc)
            {
                String[] first = s.split(":");

                double value = Double.parseDouble(first[1]);

                String[] second = first[0].split("_");
                String month = second[0];

                List<Double> list = new ArrayList<>();
                list.add(value);

                h.put(month,
                    list);
            }

            for (String s : temp)
            {
                String[] first = s.split(":");

                double value = Double.parseDouble(first[1]);

                String[] second = first[0].split("_");
                String month = second[0];

                List<Double> list = h.get(month);
                list.add(value);
            }

            Set<String> keys = h.keySet();

            for (String key : keys)
            {
                List<Double> list = h.get(key);
                c.getHistoricalweather()
                    .add(new HistoricalWeather(key,
                        list.get(0),
                        list.get(1),
                        c));
            }
        }


        /**
         * Calculates historical data averages
         */
        double totalHistPopulaion = 0;
        double totalHistInd = 0;
        double totalHistHouse = 0;
        double totalHistoricalHousing = 0;
        int totalCovidCount = 0;
        double totalCovid = 0;
        int totalPercCount = 0;
        double totalPerc = 0;
        int totalTempCount = 0;
        double totalTemp = 0;


        for (PopulationHist pop : c.getPopulationhist())
        {
            totalHistPopulaion += pop.getPop();
        }

        for (HistoricalIncome v : c.getHistoricalincome())
        {
            totalHistInd += v.getIndividualincome();
            totalHistHouse += v.getHouseholdincome();
        }

        for (HistoricalHousing h : c.getHistoricalaveragehouse())
        {
             totalHistoricalHousing += h.getHousingcost();
        }

        for (HistoricalCovid co : c.getCovid())
        {
            totalCovidCount++;
            totalCovid += co.getCases();
        }

        for (HistoricalWeather h : c.getHistoricalweather())
        {
            totalPercCount++;
            totalTempCount++;

            totalPerc += h.getPrecipitation();
            totalTemp += h.getTemperature();
        }

        c.setAveragetemp(totalTemp / totalTempCount);
        c.setAverageperc(totalPerc / totalPercCount);
        c.setAvgnewcovidcases(totalCovid / totalCovidCount);

        return cityrepo.save(c);
    }

    /**
     * Find city by citynamestate
     *
     * @param name citynamestate
     * @return city object match name or throws exception
     */
    @Override
    public City findByCName(String name)
    {
        City c = cityrepo.findByCitynamestate(name);
        if (c == null)
        {
            throw new ResourceNotFoundException("City name " + name + " not found!");
        }
        return c;
    }

    /**
     * Find all cities and their name's + id's
     *
     * @return List of City name's and Id's
     */
    @Override
    public List<CityIdName> findAllIds()
    {
        List<CityIdName> cities = new ArrayList<>();

        cityrepo.findAll()
            .iterator()
            .forEachRemaining((city) -> cities.add(new CityIdName(city.getCityid(),
                city.getCitynamestate())));

        return cities;
    }

    /**
     * Find the average value for all city fields
     * excludes historical data
     * @return a City with the field averages of all cities
     */
    @Override
    public City findAverageCity()
    {
        List<City> cities = new ArrayList<>();

        City c = new City();
        int totalCities = 0;
        String cityNameState = "National Average, USA";
        double totalLatitude = 0;
        double totalLongitude = 0;
        double totalPopulation = 0;
        double totalDensityMiSq = 0;
        double totalDensityKmSq = 0;
        double totalAge = 0;
        double totalHousehold = 0;
        double totalIndividual = 0;
        double totalHousing = 0;
        double totalRent = 0;
        double costOfLivingIndex = 0;
        double totalTemp = 0;
        double totalPerc = 0;
        double totalCov = 0;

        cityrepo.findAll()
            .iterator()
            .forEachRemaining(cities::add);

        for (int i = 0; i < cities.size(); i++)
        {
            totalCities++;
            City x = cities.get(i);
            totalLatitude += x.getLatitude();
            totalLongitude += x.getLogitude();
            totalPopulation += x.getPopulation();
            totalDensityMiSq += (c.getDensitymisq() != null) ? x.getDensitymisq() : 0;
            totalDensityKmSq += (c.getDensitykmsq() != null) ? x.getDensitykmsq() : 0;
            totalAge += x.getAverageage();
            totalHousehold += x.getHouseholdincome();
            totalIndividual += x.getIndividualincome();
            totalHousing += x.getAveragehouse();
            totalRent += x.getRent();
            totalTemp += x.getAveragetemp();
            totalPerc += x.getAverageperc();
            totalCov += x.getAvgnewcovidcases();

            costOfLivingIndex += (x.getCostoflivingindex() != null) ? x.getCostoflivingindex() : 0;
        }

        c.setCitynamestate(cityNameState);
        c.setLatitude(totalLatitude / totalCities);
        c.setLogitude(totalLongitude / totalCities);
        c.setPopulation(totalPopulation / totalCities);
        c.setDensitymisq(totalDensityMiSq / totalCities);
        c.setDensitykmsq(totalDensityKmSq / totalCities);
        c.setAverageage(totalAge / totalCities);
        c.setHouseholdincome(totalHousehold / totalCities);
        c.setIndividualincome(totalIndividual / totalCities);
        c.setAveragehouse(totalHousing / totalCities);
        c.setRent(totalRent / totalCities);
        c.setCostoflivingindex(costOfLivingIndex / totalCities);
        c.setAveragetemp(totalTemp / totalCities);
        c.setAverageperc(totalPerc / totalCities);
        c.setAvgnewcovidcases(totalCov / totalCities);

        return c;
    }


    /**
     * Finds the average city object stored in DB
     * @return National Average City
     */
    @Override
    public City returnAverageCity()
    {
        return findByCName("National Average, USA");
    }

    /**
     * Saves the city by id to current users fav cities
     * @param id cityid of city to be saved
     * @param user user extracted by controller
     */
    @Override
    public void saveFavCity(long id, User user)
    {
        City c = findCityById(id);
        UserCities us = new UserCities(user, c);

        user.getFavcities().add(us);
        c.getUsers().add(us);
    }

    @Override
    public City update(City city) {
        return null;
    }

    @Override
    public City update(CityUpdater city) {
        return null;
    }
}
