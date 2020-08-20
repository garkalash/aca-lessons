package com.aca.oop.solid.dependency_inversion.models;

public class BackendDeveloper implements Developer{
    private void writeJava(String task) {
        System.out.println("Backend developer is starting " + task);
        System.out.println("Backend developer is finished.");
    }

    private void research() {
        System.out.println("Backend developer is making research");
    }

    @Override
    public void develop(String task) {
        research();
        writeJava(task);
    }
}
