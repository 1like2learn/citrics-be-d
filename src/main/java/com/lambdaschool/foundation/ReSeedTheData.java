package com.lambdaschool.foundation;

import com.lambdaschool.foundation.dtos.CityInfo;
import com.lambdaschool.foundation.services.*;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;

import javax.transaction.Transactional;
import java.net.HttpURLConnection;
import java.net.URL;

@Transactional
//@Component
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

    @Override
    public void run(String... args) throws Exception
    {
        QueueData.cityService = this.cityService;
        QueueData.zipcodeService = this.zipcodeService;
        QueueData.historicalCovidService = this.historicalCovidService;
        QueueData.historicalHousingService = this.historicalHousingService;
        QueueData.historicalIncomeService = this.historicalIncomeService;
        QueueData.historicalWeatherService = this.historicalWeatherService;
        QueueData.countyService = this.countyService;

        // !! In order to re-seed a new database at a later time, you must change this url to the CURRENTLY DEPLOYED
        // !! url of the previous backend. 
        URL baseUrl = new URL("https://labs27-c-citrics-api.herokuapp.com/cities/allid");
        var connection = (HttpURLConnection) baseUrl.openConnection();
        connection.setRequestMethod(HttpMethod.GET.name());

        var stream = connection.getInputStream();
        ObjectMapper mapper = new ObjectMapper();
        var cities = mapper.readValue(stream, CityInfo[].class);
        var count = 1;

        for (var city : cities)
        {
            QueueData.urlQueue.addFirst(new URL(String.format("https://labs27-c-citrics-api.herokuapp.com/cities/city/%d", city.getCityid())));
        }

        for (var i = 0 ; i < QueueData.THREAD_COUNT ; i++)
        {
            ThreadedSeeder seeder = new ThreadedSeeder();
            seeder.start();
            QueueData.SEEDING_THREADS[i] = seeder;
        }
        for (var i = 0 ; i < QueueData.THREAD_COUNT ; i++)
        {
            ThreadedDownload runner = new ThreadedDownload();
            runner.start();
            QueueData.DOWNLOADING_THREADS[i] = runner;
        }

    }
}
