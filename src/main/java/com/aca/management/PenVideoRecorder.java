package com.aca.management;

public class PenVideoRecorder extends Gadget implements VideoRecorder {
    public PenVideoRecorder(Integer duration, Integer price, Integer count) {
        super(duration, price, count);
    }

    @Override
    public VideoQuality getVideoQuality() {
        return VideoQuality.VGA;
    }
}
