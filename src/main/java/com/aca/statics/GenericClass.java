package com.aca.statics;

public class GenericClass<T, V extends Number> {
    private T data;

    public void printData(T data, Integer a, V a1){
        System.out.println(data);
        System.out.println(a);
        System.out.println(a1);
    }


}

