package com.lambdaschool.foundation;

import com.lambdaschool.foundation.dtos.DataSeeder;
import com.lambdaschool.foundation.services.*;

import java.net.URL;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.locks.ReentrantLock;

public class QueueData
{
    public static final int THREAD_COUNT = Runtime.getRuntime().availableProcessors();

    public static ReentrantLock queueLock = new ReentrantLock();
    // Input of URL's
    public static Deque<URL> urlQueue = new ArrayDeque<>();

    public static ReentrantLock seedLock = new ReentrantLock();
    // Output of populated DataSeeder classes
    public static Deque<DataSeeder> seeders = new ArrayDeque<>();

    public static final ThreadedDownload[] DOWNLOADING_THREADS = new ThreadedDownload[THREAD_COUNT];

    public static final ThreadedSeeder[] SEEDING_THREADS = new ThreadedSeeder[THREAD_COUNT];

    public static CityService cityService;

    public static ZipcodeService zipcodeService;

    public static HistoricalCovidService historicalCovidService;

    public static HistoricalHousingService historicalHousingService;

    public static HistoricalIncomeService historicalIncomeService;

    public static HistoricalWeatherService historicalWeatherService;

    public static CountyService countyService;

    public static boolean downloadingThreadsStillAlive()
    {
        boolean isAlive = false;
        for(var t : DOWNLOADING_THREADS)
        {
            if(t != null && t.getThread().isAlive())
            {
                isAlive = true;
            }
        }
        return isAlive;
    }

    public static boolean seedingThreadsStillAlive()
    {
        boolean isAlive = false;
        for(var t : SEEDING_THREADS)
        {
            if(t != null && t.getThread().isAlive())
            {
                isAlive = true;
            }
        }
        return isAlive;
    }
}
