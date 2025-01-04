package org.prateek.LLDProject.RideSharingApp.V2;

public class Passenger extends User{
    public Passenger(String name, String email, Location location) {
        super(name, email, location);
    }
    //any other methods??
    public void notify(String msg){
        System.out.println("passenger : " + msg);
    }
}
