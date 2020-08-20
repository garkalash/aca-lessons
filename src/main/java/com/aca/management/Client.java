package com.aca.management;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        List<Gadget> gadgets = new ArrayList<>();
        gadgets.add(new PenAudioRecorder(5, 6000, 5, 5));
        gadgets.add(new PenVideoRecorder(5, 6000, 8));

        Manager manager = new Manager(gadgets);

        manager.getAllVideRecordersByType(VideoRecorder.VideoQuality.HD);
    }
}
