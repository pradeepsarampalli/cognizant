import java.util.Scanner;
class InvalidAgeException extends Exception{
    public InvalidAgeException(String message) {
        super(message);
    }
}

public class CustomException{
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int age;
    System.out.println("Enter your age: ");
    age = sc.nextInt();
    try {
        if (age < 18) {
            sc.close();
            throw new InvalidAgeException("Age must be at least 18.");
        } else {
            System.out.println("You are eligible to vote.");
        }
    } catch (InvalidAgeException e) {
        System.out.println("Caught exception: " + e.getMessage());
    }
    sc.close();
}
}
