package Exercise7;

public class FinancialForecast {
    public double calculate(double amount, double growth, int year) {
        if (year == 0)
            return amount;
        return calculate(amount * (1 + growth), growth, year - 1);
    }
}
