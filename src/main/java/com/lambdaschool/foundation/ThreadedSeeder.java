package com.lambdaschool.foundation;

import com.lambdaschool.foundation.models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ThreadedSeeder implements Runnable
{

    private static int threadCount = 0;
    private ReentrantLock countLock = new ReentrantLock();
    private int threadId;
    private Thread t;
    private static int seededCount = 0;

    public ThreadedSeeder()
    {
        threadCount++;
        this.threadId = threadCount;
        System.out.println(String.format("Spawning seeding thread. Count: %d", this.threadId));
    }

    @Override
    public void run()
    {
        try
        {
            Thread.sleep(50);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        while(QueueData.seeders.size() > 0 || QueueData.downloadingThreadsStillAlive()) {
            if (QueueData.seeders.size() > 0) {
                QueueData.seedLock.lock();
                var seeder = QueueData.seeders.pop();
                QueueData.seedLock.unlock();
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
                newCity = QueueData.cityService.save(newCity);
                List<String> countyNames = new ArrayList<>();
                for (var county : seeder.getCounties()) {
                    var c = new County();
                    c.setCity(newCity);
                    c.setName(county.getName());
                    newCity.getCounties().add(c);
                    countyNames.add(c.getName());
                }
                for (var covid : seeder.getCovid()) {
                    var vid = new HistoricalCovid();
                    vid.setCases(covid.getCases());
                    vid.setCity(newCity);
                    vid.setDay(covid.getDay());
                    vid.setMonth(covid.getMonth());
                    vid.setYear(covid.getYear());
                    newCity.getCovid().add(vid);
                }
                for (var house : seeder.getHistoricalaveragehouse()) {
                    var avgHouse = new HistoricalHousing();
                    avgHouse.setCity(newCity);
                    avgHouse.setHousingcost(house.getHousingcost());
                    avgHouse.setMonth(house.getMonth());
                    avgHouse.setYear(house.getYear());
                    newCity.getHistoricalaveragehouse().add(avgHouse);
                }
                for (var income : seeder.getHistoricalincome()) {
                    var i = new HistoricalIncome();
                    i.setCity(newCity);
                    i.setHouseholdincome(income.getHouseholdincome());
                    i.setIndividualincome(income.getIndividualincome());
                    i.setYear(income.getYear());
                    newCity.getHistoricalincome().add(i);
                }
                for (var weather : seeder.getHistoricalweather()) {
                    var w = new HistoricalWeather();
                    w.setCity(newCity);
                    w.setMonth(weather.getMonth());
                    w.setPrecipitation(weather.getPrecipitation());
                    w.setTemperature(weather.getTemperature());
                    newCity.getHistoricalweather().add(w);
                }
                for (var pop : seeder.getPopulationhist()) {
                    var pHis = new PopulationHist();
                    pHis.setCity(newCity);
                    pHis.setPop(pop.getPop());
                    pHis.setYear(pop.getYear());
                    newCity.getPopulationhist().add(pHis);
                }
                // TODO: use regular expressions to "clean" the zip codes coming from the old database
                for (var zip : seeder.getZipcodes()) {
                    String code = zip.getCode();
                    Pattern p = Pattern.compile("(\\d{1,5}\\D?\\d{1,5})");
                    Matcher m = p.matcher(code);
                    if (m.find()) {
                        var z = new Zipcode();
                        z.setCity(newCity);
                        z.setCode(m.group());
                        newCity.getZipcodes().add(z);
                    }
                }
                QueueData.cityService.save(newCity);
                countLock.lock();
                System.out.println(String.format("Thread %d finished seeding %d",threadId, seededCount));
                seededCount++;
                countLock.unlock();
            }
            else
            {
                try
                {
                    Thread.sleep(10);
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
            }
        }
    }

    public void start()
    {
        if(this.t == null)
        {
            this.t = new Thread(this);
        }
        this.t.start();
    }

    public Thread getThread() {
        return t;
    }
}
