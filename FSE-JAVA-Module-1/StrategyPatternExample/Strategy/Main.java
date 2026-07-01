package Strategy;

public class Main {
    public static void main(String[] args){
        PaymentContext paymentContext = new PaymentContext(new PayPalPayment());
        paymentContext.executePayment(2000);
        PaymentContext paymentContext1 = new PaymentContext(new CreditCardPayment());
        paymentContext1.executePayment(2000);
    }

}
