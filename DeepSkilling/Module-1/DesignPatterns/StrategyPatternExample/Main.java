public class Main {
    public static void main(String[] args) {
        PaymentContext paymentContext = new PaymentContext(new PayPalPayment());
        paymentContext.pay(1000);
        paymentContext = new PaymentContext(new CreditCardPayment());
        paymentContext.pay(2000);
    }
}