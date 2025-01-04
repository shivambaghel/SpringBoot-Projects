package org.prateek.SOLIDPrinciples.OCP.GoodCode;

public class PaymentProcessor {
    public void processPayment(PaymentMethod paymentMethod,double amount){
       paymentMethod.pay(amount);
    }
}
