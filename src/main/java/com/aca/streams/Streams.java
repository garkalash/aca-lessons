package com.aca.streams;


//Noise someVariable = () -> {
//                System.out.println("My noise");
//            }

// saySmthFunction = () -> System.out.println("smth");

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;


class Arithmetic{
    public static Integer add(Integer a, Integer b) {
        return a + b;
    }
}



class A{
    int data = new Random().nextInt(20);
}


interface Sum {
    int sum(int a, int b);
}

@FunctionalInterface
interface StringLengthCounter{
    int length(String s);

    default void f(){

    }
}


public class Streams {
    public static void main(String[] args) {

        List<A> aList = new ArrayList<>();
        aList.add(new A());
        aList.add(new A());
        aList.add(new A());
        aList.add(new A());
        aList.add(new A());
        aList.add(new A());
        aList.add(new A());
        aList.add(new A());
        List<Integer> datas = new ArrayList<>();
        aList.forEach(a -> datas.add(a.data));



        Double complexAvg = aList.stream()
                .mapToInt(a -> a.data)
                .filter(data -> data % 2 ==0)
                .filter(data -> data > 5)
                .average()
                .getAsDouble();

        // condition ? <true> : <false>
        Integer moreThanFive = getOpt().isPresent() ? getOpt().get() : 10;

        BiFunction<Integer, Integer, Integer> add = Arithmetic::add;

    }

    private static <T> void printWithMyRules(Predicate<T> predicate, T integer){
        if(predicate.test(integer))
            System.out.println("Good item:" + integer);
    }

    private static <T> void makeBinaryOperation(BiFunction<T, T, T> biFunction, T left, T right){
        System.out.println(biFunction.apply(left, right));
    }

    private static Optional<Integer> getOpt(){
        int randNumber = new Random().nextInt(10);
        if(randNumber > 5) return Optional.of(randNumber);
        return Optional.empty();
    }


    private static void someMethodForMain(Sum myInlineSum){
        System.out.println(myInlineSum.sum(2, 5));
    }
}
