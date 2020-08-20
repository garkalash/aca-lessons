package com.aca.pecs;


import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;



public class Main {
    public static void main(String[] args) {
        List<Integer> myIntegers = Arrays.asList(5, 2, 3);

        List<Long> myLongs = Arrays.asList(5L, 2L, 3L);

        Comparator<Number> myNumberComparator = new Comparator<Number>(){

            @Override
            public int compare(Number o1, Number o2) {
                return o1.intValue() - o2.intValue();
            }

            @Override
            public Comparator<Number> reversed() {
                return null;
            }

            @Override
            public Comparator<Number> thenComparing(Comparator<? super Number> other) {
                return null;
            }

            @Override
            public <U> Comparator<Number> thenComparing(Function<? super Number, ? extends U> keyExtractor, Comparator<? super U> keyComparator) {
                return null;
            }

            @Override
            public <U extends Comparable<? super U>> Comparator<Number> thenComparing(Function<? super Number, ? extends U> keyExtractor) {
                return null;
            }

            @Override
            public Comparator<Number> thenComparingInt(ToIntFunction<? super Number> keyExtractor) {
                return null;
            }

            @Override
            public Comparator<Number> thenComparingLong(ToLongFunction<? super Number> keyExtractor) {
                return null;
            }

            @Override
            public Comparator<Number> thenComparingDouble(ToDoubleFunction<? super Number> keyExtractor) {
                return null;
            }
        };

        Collections.sort(myIntegers, myNumberComparator ); // Number is "super" class of Integer
        Collections.sort(myLongs , myNumberComparator );
    }
}
