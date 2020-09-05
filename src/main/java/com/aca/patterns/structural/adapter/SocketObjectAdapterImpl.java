package com.aca.patterns.structural.adapter;

/**
 * @author: garik
 * @created" 9/3/2020, 8:54 PM
 */
public class SocketObjectAdapterImpl implements SocketAdapter{
    private WallSocket wallSocket = new WallSocket();

    @Override
    public Volt get120Volt() {
        return wallSocket.getVolt();
    }

    @Override
    public Volt get12Volt() {
        return new Volt(wallSocket.getVolt().getVolts() / 10);
    }

    @Override
    public Volt get3Volt() {
        return new Volt(wallSocket.getVolt().getVolts() / 40);
    }
}
