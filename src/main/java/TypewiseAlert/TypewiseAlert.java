package TypewiseAlert;

public class TypewiseAlert {
    public enum BreachType {
        NORMAL,
        TOO_LOW,
        TOO_HIGH
    }

    public enum CoolingType {
        PASSIVE_COOLING,
        HI_ACTIVE_COOLING,
        MED_ACTIVE_COOLING
    }

    public enum AlertTarget {
        TO_CONTROLLER,
        TO_EMAIL
    }

    public class BatteryCharacter {
        public CoolingType coolingType;
        public String brand;
    }

    // Simplified BreachType classification
    public static BreachType classifyTemperatureBreach(CoolingType coolingType, double temperatureInC) {
        double[] limits = getTemperatureLimits(coolingType);
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

    private static double[] getTemperatureLimits(CoolingType coolingType) {
        switch (coolingType) {
            case PASSIVE_COOLING: return new double[]{0, 35};
            case HI_ACTIVE_COOLING: return new double[]{0, 45};
            case MED_ACTIVE_COOLING: return new double[]{0, 40};
            default: throw new IllegalArgumentException("Unknown CoolingType");
        }
    }

    // Simplified alert handling
    public static void checkAndAlert(AlertTarget alertTarget, BatteryCharacter batteryChar, double temperatureInC) {
        BreachType breachType = classifyTemperatureBreach(batteryChar.coolingType, temperatureInC);
        handleAlert(alertTarget, breachType);
    }

    private static void handleAlert(AlertTarget alertTarget, BreachType breachType) {
        switch (alertTarget) {
            case TO_CONTROLLER: sendToController(breachType); break;
            case TO_EMAIL: sendToEmail(breachType); break;
            default: throw new IllegalArgumentException("Unknown AlertTarget");
        }
    }

    private static void sendToController(BreachType breachType) {
        int header = 0xfeed;
        System.out.printf("%i : %s\n", header, breachType);
    }

    private static void sendToEmail(BreachType breachType) {
        String recipient = "a.b@c.com";
        String message = getEmailMessage(breachType);
        System.out.printf("To: %s\n%s", recipient, message);
    }

    private static String getEmailMessage(BreachType breachType) {
        switch (breachType) {
            case TOO_LOW: return "Hi, the temperature is too low\n";
            case TOO_HIGH: return "Hi, the temperature is too high\n";
            case NORMAL: return "";
            default: throw new IllegalArgumentException("Unknown BreachType");
        }
    }
}
