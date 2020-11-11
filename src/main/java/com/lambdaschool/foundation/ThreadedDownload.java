package com.lambdaschool.foundation;

import com.lambdaschool.foundation.dtos.DataSeeder;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.http.HttpMethod;

import java.io.IOException;
import java.net.HttpURLConnection;

public class ThreadedDownload implements Runnable
{

    private Thread t;
    private static int count = 0;
    private int threadId;
    private static int iterations = 0;

    public ThreadedDownload()
    {
        count++;
        threadId = count;
        System.out.println(String.format("Spawning download thread. Count: %d", count));
    }

    @Override
    public void run()
    {
        int globalIteration;
        try
        {
            while(QueueData.urlQueue.size() > 0)
            {
                // acquire the lock for the deque
                QueueData.queueLock.lock();
                // this is the url to download the data from the previous database
                var myUrl = QueueData.urlQueue.pop();
                iterations++;
                globalIteration = iterations;
                // when finished accessing global variables, unlock so the next thread can access
                QueueData.queueLock.unlock();

                // Do the download
                var getUrlConnection = (HttpURLConnection) myUrl.openConnection();
                getUrlConnection.setRequestMethod(HttpMethod.GET.name());
                var getStream = getUrlConnection.getInputStream();
                ObjectMapper getMapper = new ObjectMapper();
                var seeder = getMapper.readValue(getStream, DataSeeder.class);

                QueueData.seedLock.lock();
                QueueData.seeders.add(seeder);
                System.out.println(String.format("Thread number %d just finished iteration %d", threadId, globalIteration));
                QueueData.seedLock.unlock();
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void start()
    {
        if(t == null)
        {
            t = new Thread(this);
            t.start();
        }
    }

    public Thread getThread()
    {
        return t;
    }
}
