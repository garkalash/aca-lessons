package com.aca.streams.refs;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/**
 * @author: garik
 * @created" 7/28/2020, 9:33 PM
 */
public class ByConstructor {
    public static void main(String[] args) {
        Supplier<List<String>> s = ArrayList::new;
        s.get().add("");
    }
}
