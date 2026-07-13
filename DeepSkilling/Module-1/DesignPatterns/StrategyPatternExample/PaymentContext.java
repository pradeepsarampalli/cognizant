public class PaymentContext{
    public PaymentStrategy paymentStartegy;
    public PaymentContext(PaymentStrategy ps){
        this.paymentStartegy = ps;
    }
    public void pay(double amount) {
        paymentStartegy.pay(amount);
    }
    

}