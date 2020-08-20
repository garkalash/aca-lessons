package com.aca.management;

import java.util.ArrayList;
import java.util.List;

public class Manager {
    private final List<Gadget> gadgets;
    private Integer soldAmount = 0;


    public Manager(List<Gadget> gadgets) {
        this.gadgets = gadgets;
    }

    public void sellItem(Class classOfGadget) {
        for(Gadget gadget:  gadgets) {
            if(gadget.getClass() == classOfGadget){
                gadget.setCount(gadget.getCount() - 1);
                soldAmount += gadget.getPrice();
            }
        }
    }

    public List<VideoRecorder> getAllVideRecorders(){
        List<VideoRecorder> recorders = new ArrayList<>();
        for(Gadget gadget:  gadgets) {
            if(gadget instanceof VideoRecorder){
                recorders.add((VideoRecorder) gadget);
            }
        }
        return recorders;
    }

    public List<VideoRecorder> getAllVideRecordersByType(VideoRecorder.VideoQuality videoQuality){
        List<VideoRecorder> recorders = new ArrayList<>();
        for(Gadget gadget:  gadgets) {

            if(gadget instanceof VideoRecorder){
                VideoRecorder videoRecorder = (VideoRecorder) gadget;
                if(videoRecorder.getVideoQuality() == videoQuality)
                    recorders.add((VideoRecorder) gadget);
            }
        }
        return recorders;
    }


}
