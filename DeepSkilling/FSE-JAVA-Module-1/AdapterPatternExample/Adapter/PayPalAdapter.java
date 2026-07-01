package Adapter;

public class PayPalAdapter implements PaymentProcessor {
    private PayPalGateway paypal;
    PayPalAdapter(PayPalGateway paypal){
        this.paypal = paypal;
    }
    @Override
    public void processPayment(double amount){
        paypal.sendPayment(amount);
    }

}
