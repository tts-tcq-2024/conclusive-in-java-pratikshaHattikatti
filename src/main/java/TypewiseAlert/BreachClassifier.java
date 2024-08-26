package TypewiseAlert;

public class BreachClassifier{
    public static BreachType classifyTemperatureBreach(CoolingType coolingType, double temperatureInC) {
        double[] limits = TemperatureLimits.getLimits(coolingType);
        return inferBreach(temperatureInC, limits[0], limits[1]);
    }

    private static BreachType inferBreach(double value, double lowerLimit, double upperLimit) {
        if (value < lowerLimit) {
            return BreachType.TOO_LOW;
        }
        if (value > upperLimit) {
            return BreachType.TOO_HIGH;
        }
        return BreachType.NORMAL;
    }
}

