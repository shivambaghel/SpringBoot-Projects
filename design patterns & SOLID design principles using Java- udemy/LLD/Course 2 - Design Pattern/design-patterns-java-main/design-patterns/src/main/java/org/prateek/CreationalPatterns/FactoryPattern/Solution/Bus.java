package org.prateek.CreationalPatterns.FactoryPattern.Solution;

public class Bus implements Transport {
    @Override
    public void deliver() {
        System.out.println("Deliver by bus");
    }
}
