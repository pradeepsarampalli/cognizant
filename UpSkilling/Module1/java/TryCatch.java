public class TryCatch{
    public static void main(String[] args) {
        try {
            int result = 10 / 0;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Caught an exception: " + e.getMessage());
        } 
        catch (Exception e) {
            System.out.println("Caught a generic exception: " + e.getMessage());
        }
        finally {
            System.out.println("This block will always execute.");
        }
    }
}