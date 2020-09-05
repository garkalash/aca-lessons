package com.aca.patterns.creational;

/**
 * @author: garik
 * @created" 9/1/2020, 8:43 PM
 */
class Eager {
    private static final Eager INSTANCE = new Eager();
    private Eager(){

    }

    public static Eager getInstance(){
        return INSTANCE;
    }
}

class StaticBlock {
    private static final StaticBlock INSTANCE;
    static {
        INSTANCE = new StaticBlock();
    }

    private StaticBlock(){

    }

    public static StaticBlock getInstance(){
        return INSTANCE;
    }
}

class LazyInit {
    private static LazyInit INSTANCE;

    private LazyInit(){
    }

    public static LazyInit getInstance(){
        if(INSTANCE == null) INSTANCE = new LazyInit();

        return INSTANCE;
    }
}

class ThreadSafe {
    private static ThreadSafe INSTANCE;

    private ThreadSafe(){
    }

    synchronized public static ThreadSafe getInstance(){
        if(INSTANCE == null) INSTANCE = new ThreadSafe();

        return INSTANCE;
    }
}

class DoubleCheck{
    private static DoubleCheck INSTANCE;

    private DoubleCheck(){
    }

    public static DoubleCheck getInstance(){
        if(INSTANCE == null){
            synchronized (DoubleCheck.class){
                if(INSTANCE == null){
                    INSTANCE = new DoubleCheck();
                }
            }
        }

        return INSTANCE;
    }
}

class BillPugh {
    private BillPugh(){
    }

    private static class Singleton{
        private static BillPugh INSTANCE= new BillPugh();
    }

    public static BillPugh getInstance(){ return Singleton.INSTANCE;}
}

enum SingletonEnum{
    INSTANCE;
}


public class Singleton {
}
