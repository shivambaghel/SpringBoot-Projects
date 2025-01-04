package org.prateek.LLDProject.RideSharingApp.V2;

enum RideStatus{
    SCHEDULED, ONGOING, COMPLETED;
}

public class Ride {
    private Passenger passenger;
    private Driver driver;
    private double distance;
    private FareStrategy fareStrategy;
    private double fare;
    private RideStatus status;

    public Ride(Passenger passenger,Driver driver, double distance, FareStrategy fareStrategy){
        this.passenger = passenger;
        this.driver = driver;
        this.distance = distance;
        this.fareStrategy = fareStrategy;
        this.status = RideStatus.SCHEDULED;
    }

    public void calculateFare(){
        this.fare = fareStrategy.calcFare(driver.getVehicle(), distance);
    }

    public void updateStatus(RideStatus status){
        this.status = status;
        notifyUsers(status);
    }
    private void notifyUsers(RideStatus status){
        passenger.notify("Your ride is "+status);
        driver.notify("Ride Status : "+status);
    }

    public double getFare(){
        return fare;
    }
}
