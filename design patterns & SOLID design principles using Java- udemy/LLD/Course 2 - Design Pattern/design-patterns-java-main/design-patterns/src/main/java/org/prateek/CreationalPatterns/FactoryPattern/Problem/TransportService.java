package org.prateek.CreationalPatterns.FactoryPattern.Problem;

public class TransportService {
    public static void main(String[] args) {
        //Direct create objects
        Transport car = new Car();
        Transport bike = new Bike();
        //add a bus object
        Transport bus = new Bus();
    }
}
