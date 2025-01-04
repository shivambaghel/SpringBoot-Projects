package org.prateek.LLDProject.RideSharingApp.V2;

import org.prateek.LLDProject.RideSharingApp.V1.Passenger;

abstract class User {
    protected String name;
    protected String email;
    protected Location location;

    public User(String name,String email,Location location){
        this.name = name;
        this.email = email;
        this.location = location;
    }
    //Setter
    public Location getLocation(){
        return location;
    }
    public void setLocation(Location location){
        this.location = location;
    }
    //any other methods ?
    public abstract void notify(String msg);

}
