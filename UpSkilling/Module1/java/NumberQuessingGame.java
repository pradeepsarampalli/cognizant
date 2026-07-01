import java.util.Scanner;
public class NumberQuessingGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberToGuess = Math.abs((int)(Math.random() * 100)) + 1;
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("Try to guess the number between 1 and 100.");
        int userGuess = 0;
        int attempts = 1;
        while (userGuess != numberToGuess) {
            System.out.print("Enter your guess: ");
            userGuess = sc.nextInt();
            if (userGuess < numberToGuess) {
                System.out.println("Too low! Try again.");
                attempts++;
            } else if (userGuess > numberToGuess) {
                System.out.println("Too high! Try again.");
                attempts++;
            } else {
                System.out.println("Congratulations! You've guessed the number in "+ attempts);
            }
        }
        sc.close();
    }
}