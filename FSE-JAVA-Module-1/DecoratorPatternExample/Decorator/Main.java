package Decorator;

public class Main {
    public static void main(String[] args) {
        Notifier nf = new SlackNotifierDecorator(new SMSNotifierDecorator(new EmailNotifier()));
        nf.send("Hello Upender");
    }
}
