public class Main {
    public static void main(String[] args) {
       Notifier notifier = new EmailNotifier();
       notifier = new SlackNotifierDecorator(notifier);
       notifier  = new SMSNotifierDecorator(notifier);
       notifier.send("hello");
    }
}