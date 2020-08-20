package com.aca.statics;

public class StaticContainer {
    private static NonStaticContainer nonStaticContainer = new NonStaticContainer("non1");
    private static int count = 0;
    static {
        System.out.println("message from static");
    }
    private static NonStaticContainer nonStaticContainer2 = new NonStaticContainer("non2");

    private int nonStatCount = 0;

    public StaticContainer() {
        System.out.println("Static container constructor");
        ++count;
        ++nonStatCount;
    }

    public int getCount(){
        return count;
    }

    public int getNonStatCount(){
        return nonStatCount;
    }
}
