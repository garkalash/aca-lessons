package com.aca.management;

public class PenAudioRecorder extends MemoryGadget implements AudioRecorder {

    public PenAudioRecorder(Integer duration, Integer price, Integer count, Integer memoryInGB) {
        super(duration, price, count, memoryInGB);
    }

    @Override
    public AudioType getAudioType() {
        return AudioType.MP3;
    }
}
