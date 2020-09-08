package com.aca.patterns.behavioral.state;

public interface PackageState {
    void updateState(DeliveryContext deliveryContext);
}

class Draft implements PackageState{
    private static Draft draft = new Draft();

    private Draft(){}

    public static Draft getInstance(){
        return draft;
    }

    @Override
    public void updateState(DeliveryContext deliveryContext) {
        System.out.println("Updating state from DRAFT state");
        deliveryContext.setState(Shipped.getInstance());
    }
}

class Shipped implements PackageState{
    private static Shipped draft = new Shipped();

    private Shipped(){}

    public static Shipped getInstance(){
        return draft;
    }

    @Override
    public void updateState(DeliveryContext deliveryContext) {
        System.out.println("Updating state from SHIPPED state");
        deliveryContext.setState(Delivered.getInstance());
    }
}

class Delivered implements PackageState{
    private static Delivered draft = new Delivered();

    private Delivered(){}

    public static Delivered getInstance(){
        return draft;
    }

    @Override
    public void updateState(DeliveryContext deliveryContext) {
        System.out.println("Updating state from DELIVERED state");
        System.out.println("Congrats your package delivered!");
    }
}
