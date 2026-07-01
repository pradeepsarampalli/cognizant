import java.util.Scanner;
public class RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        System.out.println("Fibonacci of " + n + " is: " + fibonacci(n));
        sc.close();
    }

    public static long fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return  n*fibonacci(n -1);
    }
}