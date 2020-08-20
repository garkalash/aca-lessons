package com.aca.management;

public interface AudioRecorder {
    AudioType getAudioType();

    enum AudioType{
        MP3, WAV;
    }
}
