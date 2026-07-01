public class Calculator {

    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }
    public boolean isEven(int n){
        return n%2  == 0;
    }
    public boolean isNegative(int n) {
        return n < 0;
    }
    public int square(int n) {
        return n * n;
    }
}