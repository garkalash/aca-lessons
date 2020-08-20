package com.aca.multithreading;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;
import java.util.stream.IntStream;

/**
 * @author: garik
 * @created" 8/20/2020, 9:44 PM
 */

class CountData {
    static int[] numbers = new int[5000];
    static {
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i + 1;
        }
    }
    static AtomicInteger count = new AtomicInteger(0);
}

class Counter extends Thread {
    private final int startInd;
    private final int endInd;
    private final Predicate<Integer> predicate;

    public Counter(String name, int startInd, int endInd, Predicate<Integer> predicate) {
        super(name);
        this.startInd = startInd;
        this.endInd = endInd;
        this.predicate = predicate;
    }

    @Override
    public void run() {
        for (int i = startInd; i < endInd; i++) {
            if(predicate.test(CountData.numbers[i])){
                CountData.count.incrementAndGet();
            }
        }
    }
}


public class PredictCounter {
    public static void main(String[] args) throws InterruptedException {
        Predicate<Integer> predicate = integer -> integer % 2 == 0;

        List<Counter> counters = Arrays.asList(
          new Counter("Counter1", 0, 400, predicate),
          new Counter("Counter2", 401, 800, predicate),
          new Counter("Counter3", 801, 1200, predicate),
          new Counter("Counter4", 1201, 1600, predicate),
          new Counter("Counter5", 1601, 2500, predicate),
          new Counter("Counter5", 2501, 5000, predicate)
        );

        System.out.println(LocalDateTime.now());
        counters.forEach(Thread::start);
        for (Counter counter : counters) {
            counter.join();
        }

        System.out.println(CountData.count.get());
        System.out.println(LocalDateTime.now());

        System.out.println(LocalDateTime.now());
        System.out.println(IntStream.of(CountData.numbers).filter(predicate::test).count());
        System.out.println(LocalDateTime.now());


    }
}
