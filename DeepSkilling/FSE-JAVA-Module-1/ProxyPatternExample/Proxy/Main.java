package Proxy;

public class Main {
    public static void main(String[] args) {
        Image img = new ProxyImage();
        img.display();
        System.out.println();
        img.display();
    }
}
