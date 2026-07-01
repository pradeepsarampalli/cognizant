package Exercise7;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner sc =  new Scanner(System.in);
        FinancialForecast financialForecast = new FinancialForecast();
        System.out.println("Enter amount , growth rate,years");
        int amount = sc.nextInt();
        double growth = sc.nextDouble();
        int year = sc.nextInt();
        System.out.printf("%.2f",financialForecast.calculate(amount,growth,year));
    }
}
