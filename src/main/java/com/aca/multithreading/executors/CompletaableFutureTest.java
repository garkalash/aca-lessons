package com.aca.multithreading.executors;

import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;
import java.util.logging.Logger;

/**
 * @author: garik
 * @created" 8/15/2020, 10:34 AM
 */
public class CompletaableFutureTest {
    public static void main(String[] args) {
        Calculator calculator = new Calculator(4, 7);

        CompletableFuture.supplyAsync(calculator)
                .thenAccept(result -> System.out.println(result));
    }
}

class Calculator implements Supplier<Integer> {
    private int x, y;

    public Calculator(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public Integer get() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }

        return x + y;
    }
}
