public class FinancialForecast {
    public static double predictFutureValue(double presentValue,double growthRate,int years){     
        if (years==0) {
            return presentValue;
        }
        return predictFutureValue(presentValue,growthRate,years - 1)*(1 + growthRate);
    }
    public static void main(String[] args) {
        double presentValue=10000;
        double growthRate=0.10;
        int years=3;
        double futureValue=predictFutureValue(presentValue,growthRate,years);
        System.out.printf("Predicted value from recursive algorithm = %.2f after %d years",futureValue,years);
    }
}