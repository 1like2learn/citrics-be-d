package com.lambdaschool.foundation;

import com.lambdaschool.foundation.dtos.DataSeeder;

import java.net.URL;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.locks.ReentrantLock;

public class QueueData
{

    public static final int THREAD_COUNT = Runtime.getRuntime().availableProcessors() * 2;

    public static ReentrantLock queueLock = new ReentrantLock();
    // Input of URL's
    public static Deque<URL> urlQueue = new ArrayDeque<>();

    public static ReentrantLock seedLock = new ReentrantLock();
    // Output of populated DataSeeder classes
    public static Deque<DataSeeder> seeders = new ArrayDeque<>();
}
