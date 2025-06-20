public class FinancialForecast {

    public static double predictFutureValue(int years, double initial, double rate) {
        if (years == 0) return initial;
        return predictFutureValue(years - 1, initial, rate) * (1 + rate);
    }

    public static void main(String[] args) {
        double initialAmount = 10000;
        double growthRate = 0.10; // 10%
        int forecastYears = 5;

        System.out.println("Financial Forecasting:");
        System.out.println("Initial Investment: ₹" + initialAmount);
        System.out.println("Annual Growth Rate: 10%\n");

        for (int i = 0; i <= forecastYears; i++) {
            double future = predictFutureValue(i, initialAmount, growthRate);
            System.out.printf("Year %d: ₹%.2f\n", i, future);
        }
    }
}
