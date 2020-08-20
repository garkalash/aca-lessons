package com.aca.management;

public abstract class Gadget {
    private final Integer duration;
    private Integer price;
    private Integer count;

    public Gadget(Integer duration, Integer price, Integer count) {
        this.duration = duration;
        this.price = price;
        this.count = count;
    }

    public Integer getDuration() {
        return duration;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
