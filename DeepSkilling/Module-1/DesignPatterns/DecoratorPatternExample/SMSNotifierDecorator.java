public class SMSNotifierDecorator  extends NotifierDecorator {
    public SMSNotifierDecorator(Notifier notifier) {
        super(notifier);
    }
    int count =0;
    public void send(String message){
        notifier.send(message);
        System.out.println("SMS sent");
    }
}