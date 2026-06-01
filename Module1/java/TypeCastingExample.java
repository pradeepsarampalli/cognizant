public class TypeCastingExample {
    public static void main(String[] args) {
        // Implicit Type Casting (Widening) -called type conversion
        int num1 = 100;
        double num2 = num1;
        System.out.println("Implicit Type Casting: " + num2);

        // Explicit Type Casting (Narrowing) - called type casting
        double num3 = 9.99;
        int num4 = (int) num3; 
        System.out.println("Explicit Type Casting: " + num4); 
    }
}