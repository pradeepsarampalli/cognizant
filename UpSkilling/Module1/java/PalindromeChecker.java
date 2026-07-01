import java.util.Scanner;
public class PalindromeChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String str = sc.nextLine();
        StringBuilder sb = new StringBuilder(str);
        for(int i=0;i<sb.length();i++){
            if(!Character.isLetterOrDigit(sb.charAt(i))){
                sb.deleteCharAt(i);
                i--;
            }
        }
        String cleanedStr = sb.toString();
        String reversedStr = new StringBuilder(cleanedStr).reverse().toString();
        if (cleanedStr.equals(reversedStr)) {
            System.out.println(str + " is a palindrome.");
        } else {
            System.out.println(str + " is not a palindrome.");
        }
        sc.close();
    }
}