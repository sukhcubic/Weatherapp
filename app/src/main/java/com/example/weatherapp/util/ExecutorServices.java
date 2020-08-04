package com.example.weatherapp.util;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class ExecutorServices {
    private static ExecutorServices instance;

    public static ExecutorServices getInstance(){
        if(instance == null){
            instance = new ExecutorServices();
        }
        return instance;
    }

    //Choosing one thread for this app
    private final ScheduledExecutorService newtworkIO = Executors.newScheduledThreadPool(1);
    
    public ScheduledExecutorService networkIO(){
        return newtworkIO;
    }
}
