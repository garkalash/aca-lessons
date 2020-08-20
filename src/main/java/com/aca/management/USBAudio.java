package com.aca.management;

public class USBAudio extends MemoryGadget implements AudioRecorder {
    public USBAudio(Integer duration, Integer price, Integer count, Integer memoryInGB) {
        super(duration, price, count, memoryInGB);
    }

    @Override
    public AudioType getAudioType() {
        return AudioType.WAV;
    }
}
