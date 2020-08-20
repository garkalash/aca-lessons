package com.aca.multithreading.executors;

import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author: garik
 * @created" 8/20/2020, 8:38 PM
 */
public class SchedulingDemo {
    public static void main(String[] args) {
        scheduleTask();

    }

    private static  void scheduleTask(){
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);

        scheduledExecutorService.scheduleAtFixedRate(() -> System.out.println("message from schedule" + LocalDateTime.now().toString()),
                0L, 4L, TimeUnit.DAYS);

    }
}
