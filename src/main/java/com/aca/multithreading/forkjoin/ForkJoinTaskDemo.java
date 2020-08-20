package com.aca.multithreading.forkjoin;

import java.time.LocalDateTime;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.stream.IntStream;

/**
 * @author: garik
 * @created" 8/20/2020, 9:08 PM
 */
public class ForkJoinTaskDemo {
    public static void main(String[] args) {
        int nThreads = Runtime.getRuntime().availableProcessors();

        int[] numbers = new int[1000];
        for(int i=0; i < numbers.length; ++i){
            numbers[i] = i + 1;
        }

        ForkJoinPool forkJoinPool = new ForkJoinPool(nThreads);
        System.out.println(LocalDateTime.now());
        Integer sum = 0;
        for(int i = 0; i < numbers.length; ++i){
            sum += numbers[i];
        }
        System.out.println(sum);
        System.out.println(LocalDateTime.now());
        System.out.println(">>>>>>>>>>>>>>>");
        System.out.println(LocalDateTime.now());
        sum = IntStream.of(numbers).sum();
        System.out.println(IntStream.of(numbers).sum());
        System.out.println(LocalDateTime.now());
    }
}

class Sum extends RecursiveTask<Integer>{
    private int lowInd;
    private int highInd;
    private int[] arr;

    public Sum(int lowInd, int highInd, int[] arr) {
        this.lowInd = lowInd;
        this.highInd = highInd;
        this.arr = arr;
    }

    @Override
    protected Integer compute() {

        if(highInd - lowInd <= 100){
            int sum = 0;
            for(int i = lowInd; i < highInd; ++i){
                sum += arr[i];
            }
            return sum;
        } else {
            int mid = lowInd + (highInd - lowInd)/2;
            Sum left = new Sum(lowInd, mid, arr);
            left.fork();
            Sum right = new Sum(mid, highInd, arr);
            right.fork();
            return left.join() + right.join();
        }
    }
}
