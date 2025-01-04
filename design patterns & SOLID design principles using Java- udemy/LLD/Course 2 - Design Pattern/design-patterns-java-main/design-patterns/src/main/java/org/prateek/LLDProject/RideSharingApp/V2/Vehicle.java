package org.prateek.LLDProject.RideSharingApp.V2;

abstract class Vehicle {
    protected String numberPlate;

    public Vehicle(String numberPlate){
        this.numberPlate = numberPlate;
    }
    //Fare Calc
    public abstract double getFarePerKm();
}
