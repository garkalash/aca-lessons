package com.aca.patterns.behavioral.template;

/**
 * @author: garik
 * @created" 9/8/2020, 10:58 PM
 */
public abstract class HouseTemplate {

    public final void buildHouse(){
        buildFoundation();
        buildWalls();
        buildWindows();
        buildDoors();
    }

    public abstract void buildFoundation();
    public abstract void buildWalls();
    public abstract void buildWindows();
    public abstract void buildDoors();

}
