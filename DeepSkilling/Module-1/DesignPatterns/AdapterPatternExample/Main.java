public class Main {
    public static void main(String[] args) {
        PaymentProcessor pp = new PaymentAdapter();
        pp.pay(1000);
    }
}