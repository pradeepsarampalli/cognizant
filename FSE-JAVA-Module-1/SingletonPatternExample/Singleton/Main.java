package Singleton;

public class Main {

    public static void main(String[] args) {
        Logger l1 = Logger.getLogger();
        Logger l2 = Logger.getLogger();
        l1.print();
        System.out.println(l2 == l1);
    }
}