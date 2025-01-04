package org.prateek.Basics.OOPS;

public class UPI implements PaymentMethod{
    String upiId;

    UPI(String id){
        this.upiId = id;
    }

    @Override
    public void pay() {
        System.out.println("Making payment via UPI "+upiId);
    }
}
