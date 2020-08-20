package com.aca.streams.collectors;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;
import static java.util.stream.Collectors.toSet;

/**
 * @author: garik
 * @created: 7/28/2020, 9:40 PM
 */
public class MyCollectors {
    public static void main(String[] args) {


        List<String> givenList = Arrays.asList("aa", "bb", "a", "c","g", "John Joe", "Poghos Poghosyan", "Super Mario");

         List<String> resultList = givenList
                .parallelStream()
                .filter(s -> s.length() > 1)
                .filter(s -> s.charAt(1) == 'o')
         .collect(Collectors.toCollection(LinkedList::new));

         Map<String, Integer> lengths = givenList
                 .parallelStream()
                 .collect(toMap((s)-> s, String::length));

         String string = givenList.stream().collect(Collectors.joining(" | ", "PREFIX ", " POSTFIX"));

         Long count = givenList.stream().collect(Collectors.counting());

        DoubleSummaryStatistics stats = givenList.stream().collect(Collectors.summarizingDouble(String::length));

        Map<Integer, Set<String>> groupedByLength = givenList.stream().collect(Collectors.groupingBy(String::length, toSet()));
        Map<Boolean, List<String>> partiotionedByLength = givenList.stream().collect(Collectors.partitioningBy(s -> s.length() > 5));

         System.out.println(count);
    }

}
