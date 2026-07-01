import java.util.*;
public class Calculator {
    public static void main(String[] args) {
        int a;
        int b;
        char operator;

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first number: ");
        a=sc.nextInt();
        System.out.println("Enter second number: ");
        b=sc.nextInt();
        System.out.println("Enter operator (+, -, *, /): ");
        operator=sc.next().charAt(0);
        switch (operator) {
            case '+':
                System.out.println("Result: " + (a + b));
                break;
            case '-':
                System.out.println("Result: " + (a - b));
                break;
            case '*':
                System.out.println("Result: " + (a * b));
                break;
            case '/':
                if (b != 0) {
                    System.out.println("Result: "+String.format("%.2f",(a/(double)b)));
                } else {
                    System.out.println("Error: Division by zero");
                }
                break;
            default:
                System.out.println("Invalid operator");
        }
        sc.close();
    }
}
