package com.aca.oop.solid.dependency_inversion.models;

public class FrontendDeveloper implements Developer{
    public void writeJavascript(String task) {
        System.out.println("Frontend developer is starting " + task);
        System.out.println("Frontend developer is finished.");
    }

    @Override
    public void develop(String task) {
        writeJavascript(task);
    }
}
