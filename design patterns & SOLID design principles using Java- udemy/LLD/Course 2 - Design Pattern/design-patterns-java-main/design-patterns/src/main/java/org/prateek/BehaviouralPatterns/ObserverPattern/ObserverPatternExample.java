package org.prateek.BehaviouralPatterns.ObserverPattern;

import java.util.ArrayList;
import java.util.List;

//Observer Interface
interface Observer{
    void update(float temp);
}

//Subject Interface
interface Subject{
    void attach(Observer obs);
    void detach(Observer obs);
    void notifyObservers();
}


// Weather Station
class WeatherStationIn implements Subject{
    private float temperature;
    private List<Observer> observerList;

    public WeatherStationIn(){
        observerList = new ArrayList<>(); //Empty
    }

    public void setTemperature(float temperature){
        this.temperature = temperature;
        notifyObservers();
    }

    @Override
    public void attach(Observer obs) {
        observerList.add(obs);
    }

    @Override
    public void detach(Observer obs) {
        observerList.remove(obs);
    }

    @Override
    public void notifyObservers() {
        for(Observer obs:observerList){
            obs.update(temperature); //Run Time Polymorphism
        }
    }
}


class DisplayDeviceIn implements Observer{
    String name;
    public DisplayDeviceIn(String deviceName){
        this.name = deviceName;
    }
    @Override
    public void update(float temp) {
        System.out.println("Temp on " + name +" device is "+temp);
    }
}
class MobileDevice implements Observer{
    @Override
    public void update(float temp) {
        System.out.println("Temp on mobile is "+temp);
    }
}


public class ObserverPatternExample {
    public static void main(String[] args) {
        //Create a Publisher
        WeatherStationIn weatherStationIn = new WeatherStationIn();

        //Create subscribers
        DisplayDeviceIn device = new DisplayDeviceIn("SamsungLCD");
        MobileDevice mobileDevice = new MobileDevice();

        //Attach
        weatherStationIn.attach(device);
        weatherStationIn.attach(mobileDevice);

        //Set Temp
        weatherStationIn.setTemperature(25);

        //Detach
        weatherStationIn.detach(mobileDevice);

        weatherStationIn.setTemperature(26);

    }
}
