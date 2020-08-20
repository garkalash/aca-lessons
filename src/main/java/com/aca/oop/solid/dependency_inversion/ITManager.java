package com.aca.oop.solid.dependency_inversion;

import com.aca.oop.solid.dependency_inversion.models.BackendDeveloper;
import com.aca.oop.solid.dependency_inversion.models.Developer;
import com.aca.oop.solid.dependency_inversion.models.FrontendDeveloper;

public class ITManager {
    private Developer backendDeveloper = new BackendDeveloper();
    private Developer frontendDeveloper = new FrontendDeveloper();

    public void develop(String frontTask, String backendTask) {
        frontendDeveloper.develop(frontTask);
        backendDeveloper.develop(backendTask);
    }
}
