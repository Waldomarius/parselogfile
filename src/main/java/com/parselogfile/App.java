package com.parselogfile;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App
{
    public static void main( String[] args ){
        LogFiles firstThread = new LogFiles();
        LogFiles secondThread = new LogFiles();

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        executorService.submit(firstThread);
        executorService.submit(secondThread);
        executorService.shutdown();
    }
}
