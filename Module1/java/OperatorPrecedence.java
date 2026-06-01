public class OperatorPrecedence {
    public static void main(String[] args) {
        int result = 10 + 5 * 2; // Multiplication has higher precedence than addition
        System.out.println("Result of 10 + 5 * 2: " + result); // Output will be 20

        result = (10 + 5) * 2; // Parentheses change the order of evaluation
        System.out.println("Result of (10 + 5) * 2: " + result); // Output will be 30

        result = 10 - 5 + 2; // Subtraction and addition have the same precedence, evaluated left to right
        System.out.println("Result of 10 - 5 + 2: " + result); // Output will be 7

        result = 10 / 2 * 3; // Division and multiplication have the same precedence, evaluated left to right
        System.out.println("Result of 10 / 2 * 3: " + result); // Output will be 15
    }
}