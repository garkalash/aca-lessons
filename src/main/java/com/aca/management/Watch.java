package com.aca.management;

public class Watch extends MemoryGadget implements AudioRecorder, VideoRecorder{


    public Watch(Integer duration, Integer price, Integer count, Integer memoryInGB) {
        super(duration, price, count, memoryInGB);
    }

    @Override
    public AudioType getAudioType() {
        return AudioType.MP3;
    }

    @Override
    public VideoQuality getVideoQuality() {
        return VideoQuality.HD;
    }
}
