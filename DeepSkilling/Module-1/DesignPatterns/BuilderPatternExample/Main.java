public class Main {
    public static void main(String[] a) {
        System.out.println(new Computer.Builder().cpu("i7").ram("16GB").storage("1TB").build());
    }
}