package com.aca.oop.solid;

import com.aca.oop.solid.dependency_inversion.ITManager;

public class ITClient {
    public static void main(String[] args) {
        ITManager itManager = new ITManager();
        itManager.develop("A nice front", "A strong backend");
    }

}
