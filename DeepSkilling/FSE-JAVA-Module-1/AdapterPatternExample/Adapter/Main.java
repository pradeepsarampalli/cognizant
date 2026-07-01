package Adapter;

public class Main {
    public static void main(String[] args) {
        PaymentProcessor pp = new PayPalAdapter(new PayPalGateway());
        pp.processPayment(2000);
    }
}
