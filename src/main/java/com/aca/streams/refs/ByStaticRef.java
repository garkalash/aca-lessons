package com.aca.streams.refs;

/**
 * @author: garik
 * @created: 7/28/2020, 8:59 PM
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;

import static com.aca.streams.refs.Numbers.*;

class Numbers{
    public static boolean isMoreFifty(int n1, int n2){ return (n1 + n2) > 50;}

    public static List<Integer> findNumbers(List<Integer> l, BiPredicate<Integer, Integer> p) {
        List<Integer> newList = new ArrayList<>();
        for(Integer i : l){
            if(p.test(i, i + 10)){
                newList.add(i);
            }
        }
        return newList;
    }
}


public class ByStaticRef {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(12, 5, 45, 30);

        findNumbers(list, new BiPredicate<Integer, Integer>() {
            @Override
            public boolean test(Integer integer, Integer integer2) {
                return isMoreFifty(integer, integer2);
            }
        });

        findNumbers(list, (i1, i2) -> isMoreFifty(i1, i2));

        findNumbers(list, Numbers::isMoreFifty);
    }
}
