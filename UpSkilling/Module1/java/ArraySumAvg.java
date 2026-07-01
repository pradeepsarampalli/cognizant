import java.util.Scanner;
public class ArraySumAvg {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n=sc.nextInt();
        int[] numbers = new int[n];
        System.out.println("Enter the elements: ");
        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        double average = sum/(double)numbers.length;
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + String.format("%.2f", average));
        sc.close();
    }

}