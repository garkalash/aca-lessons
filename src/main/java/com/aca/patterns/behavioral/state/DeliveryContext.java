package com.aca.patterns.behavioral.state;

/**
 * @author: garik
 * @created" 9/8/2020, 10:29 PM
 */
public class DeliveryContext {
    private PackageState state;
    private final String packageId;

    public DeliveryContext(String packageId, PackageState state){
        this.state = state;
        this.packageId = packageId;

        if(this.state == null) this.state = Draft.getInstance();
    }

    public PackageState getState() {
        return state;
    }

    public void setState(PackageState state) {
        this.state = state;
    }

    public String getPackageId() {
        return packageId;
    }

    public void update(){
        this.state.updateState(this);
    }
}
