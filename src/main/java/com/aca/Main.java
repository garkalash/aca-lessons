package com.aca;

import java.util.*;

class TwoItems<E> {
    private Object[] data;
    private final int INITIAL_CAPACITY = 16;
    private int current = -1;

    public TwoItems(){
        data = new Object[2];
    }

    public E getFirst() {
        return (E) data[0];
    }

    public E getSecond() {
        return (E) data[1];
    }

    public void setFirst(E item) {
        data[0] = item;
    }

    public void setSecond(E item) {
        data[1] = item;
    }

    public void copyItemsIntoSrc(List<? super E> src){
        src.add(getFirst());
        src.add(getSecond());
    }

    public static void main(String[] args) {
        TwoItems<Number> numberTwoItems = new TwoItems<>();
        numberTwoItems.setFirst(5);
        numberTwoItems.setSecond(15L);
        List<Number> numbers = new ArrayList<>();
        numberTwoItems.copyItemsIntoSrc(numbers);
        System.out.println(numbers.get(0) + " " +numbers.get(1));
    }

}

class Animal {
    Integer id;
    Integer avgRate;

    @Override
    public boolean equals(Object obj) {
        return this.id.equals((Integer)obj);
    }
}


class Farm<T extends Animal> {
    public static void main(String[] args) {
        Animal animal1 = new Animal();
        animal1.id = 1;
        animal1.avgRate = 2;
        Animal animal2 = new Animal();
        animal2.id = 2;
        animal2.avgRate = 4;
        Animal animal3 = new Animal();
        animal3.id = 3;
        animal3.avgRate = 2;
        Animal animal4 = new Animal();
        animal4.id = 4;
        animal4.avgRate = 7;

        Set<Animal> animals = new TreeSet<>(Comparator.comparingInt(o -> o.avgRate));

        animals.add(animal1);
        animals.add(animal2);
        animals.add(animal3);
        animals.add(animal4);

        System.out.println(animals);
    }
}





/*class Test<T>{
    T[] elements;
    *//* Restrictions *//*
    public Test(){
        Object a = null;
        *//*No primitive*//*

        *//* At runtime all types are raw*//*
        if(a instanceof ArrayList){

        }

        //can cause classcastexception
        @SuppressWarnings("unchecked") ArrayList<String> list = (ArrayList<String>) a;


        *//* Don't instantiate type *//*
        //T[] ts = new T[5];
        //in arrayList object[] instead of E[]
        String[] elements = (String[]) new Object[4];


        *//* Generic can't be throwable*//*
        *//* can't catch *//*
        *//* used T extends Throwable *//*
    }

    public T get(int index){
        return elements[index];
    }
}*/

class Test {
    String str = "a";
    void aMethod() {
        try {
            str +="b";
            bMethod();
        } catch (Exception e) {
            str += "c";
        }
    }

    void bMethod() throws Exception {
        try {
            str += "d";
            cMethod();
        } catch(Exception e) {
            throw new Exception();
        } finally {
            str += "e";
        }
        str += "f";
    }

    void cMethod() throws Exception {
        throw new Exception();
    }

    void display() {
        System.out.println(str);
    }

    public static void main(String[] args)
    {
        Test object = new Test();
        object.aMethod();
        object.display();
    }

}
class Generic<T extends Number> {

    public void printAllItems(List<T> items){
        for(T item: items)
            System.out.println(item.toString());
    }

    public static void main(String[] args) {
        Generic<Number> generic = new Generic<>();

        List<Number> numbers = Arrays.asList(5, 10, 20);
        List<Integer> otherNumbers = Arrays.asList(10, 20, 35);

        generic.printAllItems(numbers);
    }
}



/**
 * John 18
 * Poghos 20
 */


class Fruit {}

class Apple extends Fruit{}
class Pear extends Fruit{}

class YellowApple extends Apple {}
class RedApple extends Apple {}

class YellowPear extends Pear {}
class RedPear extends Pear {}

class A{
    Integer data;
}

public class Main {
    public static void main(String[] args) {
        A a = new A();
        a.data = 5;
        f(a);
        System.out.println(a.data);



    }

    private static void f(A a){a.data = 10;}

    private static <E extends Comparable<E>> E max(List<? extends E> list){
        E max = list.get(0);
        for(int i= 1; i<list.size(); ++i) {
            if(max.compareTo(list.get(i)) < 0) max =list.get(i);
        }
        return max;
    }

    private static void extendedArray(Object[] objects){
        for (Object object: objects) {
            System.out.println(object);
        }
    }

    private  static void extendedList(List<Object> objects){
        for (Object object: objects) {
            System.out.println(object);
        }
    }

    //typed generic
    private static <T> T addTypedList(List<T> objects, T a){
        if(objects.add(a)){
            return a;
        }
        return null;
    }

    //wildcard
    private static void addWildList(List<?> objects, int index){
        objects.remove(index);
    }

    //wildcard extend
    private static void getWildExtendList(List<? extends Number> objects, int index){
        //captureWildcard(objects);
        objects.get(index);
    }

    private static <T> void captureWildcard(List<T> objects){
        objects.add(objects.get(0));
    }


    //wildcard extend
    private static void addWildSuperList(List<? extends Apple> from, List<? super Apple> to) {
        Apple apple = from.get(0);

        to.add(apple);
    }




}




