package org.prateek.Basics.OOPS;

public class DebitCard extends Card{
    public DebitCard(String cardNo, String name) {
        super(cardNo, name);
    }

    @Override
    public void pay() {
        System.out.println("Making payment via Debit Card " + cardNo);
    }
}
