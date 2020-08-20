package com.aca.multithreading.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author: garik
 * @created" 8/13/2020, 10:35 PM
 */
public class Example {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("A");
        strings.add("B");
        strings.add("C");

        //strings.iterator().forEachRemaining(s -> strings.remove(s));

        while (strings.iterator().hasNext()){
            strings.iterator().remove();
        }


        System.out.println(strings);
    }
}
