package com.aca.patterns.structural.adapter;

/**
 * @author: garik
 * @created" 9/3/2020, 8:52 PM
 */
public class SocketClassAdapterImpl extends WallSocket implements SocketAdapter{
    @Override
    public Volt get120Volt() {
        return getVolt();
    }

    @Override
    public Volt get12Volt() {
        return new Volt(getVolt().getVolts() / 10);
    }

    @Override
    public Volt get3Volt() {
        return new Volt(getVolt().getVolts() / 40);
    }

}
