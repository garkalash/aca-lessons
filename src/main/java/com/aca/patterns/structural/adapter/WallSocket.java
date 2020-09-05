package com.aca.patterns.structural.adapter;

/**
 * @author: garik
 * @created" 9/3/2020, 8:49 PM
 */
public class WallSocket {
    public Volt getVolt(){
        return new Volt(120);
    }
}
