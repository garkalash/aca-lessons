package com.aca.statics;

public class NonStaticContainer implements Comparable<NonStaticContainer>{

    public NonStaticContainer(String message){
        System.out.println(message);
    }

    @Override
    public int compareTo(NonStaticContainer o) {
        return 0;
    }
}
