public class PaymentAdapter implements PaymentProcessor{
    private PaymentGateway paymentGateway;
    public PaymentAdapter(){
        paymentGateway = new PaymentGateway();
    }
    @Override
    public void pay(int amount){
        paymentGateway.processPay(amount);
    }

}