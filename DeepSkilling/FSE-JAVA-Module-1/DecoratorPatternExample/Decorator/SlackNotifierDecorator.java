package Decorator;

public class SlackNotifierDecorator extends NotifierDecorator{
    public SlackNotifierDecorator(Notifier notifier){
        super(notifier);
    }
    @Override
    public void send(String message){
        super.send(message);
        System.out.println("Sending messages "+message);
    }
}
