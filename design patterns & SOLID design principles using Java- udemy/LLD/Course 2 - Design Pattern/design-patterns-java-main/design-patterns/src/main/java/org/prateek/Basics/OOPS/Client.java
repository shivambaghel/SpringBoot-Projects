package org.prateek.Basics.OOPS;

public class Client {
    public static void main(String[] args) {
        PaymentService ps = new PaymentService();
        ps.addPaymentMethod("PrateekDebitCard",new DebitCard("1234","Prateek Narang"));
        ps.addPaymentMethod("PrateekCreditCard",new CreditCard("5678","Prateek Narang"));
        ps.addPaymentMethod("PrateekUPI",new UPI("prateek27"));
        ps.addPaymentMethod("PrateekWallet",new Wallet());
        ps.makePayment("PrateekUPI");
        ps.makePayment("PrateekDebitCard");
        ps.makePayment("PrateekWallet");

    }
}
