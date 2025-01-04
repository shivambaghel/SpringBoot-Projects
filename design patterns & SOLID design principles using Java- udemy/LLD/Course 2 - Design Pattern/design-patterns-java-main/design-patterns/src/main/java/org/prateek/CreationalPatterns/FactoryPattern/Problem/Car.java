package org.prateek.CreationalPatterns.FactoryPattern.Problem;

public class Car implements Transport{
    @Override
    public void deliver() {
        System.out.println("Deliver by car");
    }
}
