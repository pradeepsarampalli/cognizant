package Builder;

public class Main {
    public static void main(String[] args) {
        Computer obj = new Computer.Builder().setCpu("intel").build();
        System.out.println(obj);
    }
}
