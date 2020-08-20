package com.aca.oop.solid.liskov;

import java.util.List;

public class BirdManager {

    public void flyBirds(List<Bird> birds) {
        for(Bird bird : birds) {
            bird.fly();
        }
    }

    public void eatBirds(List<Bird> birds) {
        for(Bird bird : birds) {
            bird.eat();
        }
    }
}
