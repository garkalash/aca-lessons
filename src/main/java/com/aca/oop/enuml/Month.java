package com.aca.oop.enuml;

public enum Month implements Print{
    JANUARY(1, 25),
    FEBRUARY(2, 26),
    MARCH(3, 15);

    private  static int a = 0;

    static {
        a = 5;
    }

    private int id;
    private int daysCount;

    Month(int i, int daysCount) {

        this.id = i;
        this.daysCount = daysCount;
    }



    public int getId() {
        return id;
    }

    public int getDaysCount() {
        return daysCount;
    }

    @Override
    public void print() {

    }
}
