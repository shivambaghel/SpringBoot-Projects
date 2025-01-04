package org.prateek.BehaviouralPatterns.StrategyPattern;

interface PaymentStrategy{
    void processPayment();
}
//Concrete Strategy: Credit Card
class CreditCardPayment implements PaymentStrategy{

    @Override
    public void processPayment() {
        System.out.println("Making payment via Credit Card");
    }
}
//Concrete Strategy: Debit Card
class DebitCardPayment implements PaymentStrategy{

    @Override
    public void processPayment() {
        System.out.println("Making payment via Debit Card");
    }
}

class UPIPayment implements PaymentStrategy{

    @Override
    public void processPayment() {
        System.out.println("Making payment via UPI");
    }
}


class PaymentServiceII{
    private PaymentStrategy strategy;
    public void setPaymentStrategy(PaymentStrategy strategy){
        this.strategy = strategy;
    }

    public void pay(){
        strategy.processPayment(); //Polymorphic Behaviour
    }

}


public class StrategyPattern {
    public static void main(String[] args) {
        PaymentServiceII paymentService = new PaymentServiceII();
        paymentService.setPaymentStrategy(new UPIPayment());
        paymentService.pay();
    }
}
