package org.prateek.Basics.OOPS;

public class CreditCard extends Card{
    public CreditCard(String cardNo, String name) {
        super(cardNo, name);
    }

    @Override
    public void pay() {
        System.out.println("Making payment via Credit Card");
    }
}
