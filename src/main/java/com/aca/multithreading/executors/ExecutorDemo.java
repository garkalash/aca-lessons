package com.aca.multithreading.executors;

import java.util.concurrent.*;

/**
 * @author: garik
 * @created" 8/15/2020, 10:16 AM
 */
public class ExecutorDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService ex1 = Executors.newFixedThreadPool(3);
        ExecutorService ex2 = Executors.newSingleThreadExecutor();
        ScheduledExecutorService ex3 = Executors.newScheduledThreadPool(2);

        Callable<Integer> task = () -> {
            try{
                TimeUnit.SECONDS.sleep(2);
                return 123;
            } catch (InterruptedException interruptedException){
                throw new IllegalStateException("task interrupted", interruptedException);
            }
        };

        ex1.submit(() -> System.out.println("print from runnable"));

        Future<Integer> integerFuture = ex1.submit(task);

        System.out.println("Is done: " + integerFuture.isDone());

        Integer result = integerFuture.get();

        System.out.println("Is done: " + integerFuture.isDone());
        System.out.println("Is done: " + integerFuture.isDone());










    }
}
