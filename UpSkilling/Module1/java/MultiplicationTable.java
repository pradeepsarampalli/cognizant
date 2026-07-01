import java.util.Scanner;
public class MultiplicationTable {
    public static void main(String[] args) {
        int number;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        number = sc.nextInt();
        System.out.println("Multiplication Table for " + number);
        for (int i = 1; i <= 10; i++) {
            System.out.println(number + " x " + i + " = " + (number * i));
        }
        sc.close();
    }
}