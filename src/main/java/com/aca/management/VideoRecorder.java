package com.aca.management;

public interface VideoRecorder {
    VideoQuality getVideoQuality();

    enum VideoQuality {
        HD, VGA;
    }

}
