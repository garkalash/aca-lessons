package com.aca.management;

public abstract class MemoryGadget extends Gadget {
    private final Integer memoryInGB;

    public MemoryGadget(Integer duration, Integer price, Integer count, Integer memoryInGB) {
        super(duration, price, count);
        this.memoryInGB = memoryInGB;
    }

    public Integer getMemoryInGB() {
        return memoryInGB;
    }
}
