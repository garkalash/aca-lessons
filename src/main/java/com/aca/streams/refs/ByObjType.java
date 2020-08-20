package com.aca.streams.refs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.IntStream;

/**
 * @author: garik
 * @created: 7/28/2020, 9:10 PM
 */

class Shipment{
    private Integer quantity;
    private Double unitWeight;

    public Shipment(Integer quantity, Double unitWeight) {
        this.quantity = quantity;
        this.unitWeight = unitWeight;
    }

    public double calculateWeight(Shipment s){
        return s.unitWeight * s.quantity;
    }
}

class ShipmentManager {
    public List<Double> calculateOnShipments(List<Shipment> l, Function<Shipment, Double> f){
        List<Double> results = new ArrayList<>();
        for(Shipment s: l) {
            results.add(f.apply(s));
        }
        return results;
    }

    public Double calculateWeight(Shipment shipment, Function<Shipment, Double> function){
        return function.apply(shipment);
    }
}



public class ByObjType {
    public static void main(String[] args) {
        ShipmentManager manager = new ShipmentManager();
        Shipment shipment = new Shipment(5, 20.00);

        manager.calculateWeight(shipment, (s) -> s.calculateWeight(s));

    }
}
