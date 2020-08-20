package com.aca.oop.solid;

import com.aca.oop.solid.liskov.*;

import java.util.ArrayList;
import java.util.List;

public class BirdClient {
    public static void main(String[] args) {
        BirdManager birdManager = new BirdManager();
        List<Bird> birds = new ArrayList<>();
        birds.add(new Crow("Mimi"));
        birds.add(new Ostrich("Mini"));
        birds.add(new Collibri("Miko"));

        birdManager.flyBirds(birds);
        birdManager.eatBirds(birds);
    }
}
