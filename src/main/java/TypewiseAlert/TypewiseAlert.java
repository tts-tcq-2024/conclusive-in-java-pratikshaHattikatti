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

    // Refactored inferBreach function to limit complexity
    private static BreachType inferBreach(double value, double lowerLimit, double upperLimit) {
        if (value < lowerLimit) {
            return BreachType.TOO_LOW;
        }
        if (value > upperLimit) {
            return BreachType.TOO_HIGH;
        }
        return BreachType.NORMAL;
    }

    // New function to get temperature limits based on cooling type
    private static double[] getTemperatureLimits(CoolingType coolingType) {
        switch (coolingType) {
            case PASSIVE_COOLING:
                return new double[]{0, 35};
            case HI_ACTIVE_COOLING:
                return new double[]{0, 45};
            case MED_ACTIVE_COOLING:
                return new double[]{0, 40};
            default:
                throw new IllegalArgumentException("Unknown CoolingType");
        }
    }

    // Refactored classifyTemperatureBreach function
    public static BreachType classifyTemperatureBreach(CoolingType coolingType, double temperatureInC) {
        double[] limits = getTemperatureLimits(coolingType);
        return inferBreach(temperatureInC, limits[0], limits[1]);
    }

    // Refactored checkAndAlert function to limit complexity
    public static void checkAndAlert(AlertTarget alertTarget, BatteryCharacter batteryChar, double temperatureInC) {
        BreachType breachType = classifyTemperatureBreach(batteryChar.coolingType, temperatureInC);

        switch (alertTarget) {
            case TO_CONTROLLER:
                sendToController(breachType);
                break;
            case TO_EMAIL:
                sendToEmail(breachType);
                break;
            default:
                throw new IllegalArgumentException("Unknown AlertTarget");
        }
    }

    private static void sendToController(BreachType breachType) {
        int header = 0xfeed;
        System.out.printf("%i : %s\n", header, breachType);
    }

    private static void sendToEmail(BreachType breachType) {
        String recipient = "a.b@c.com";
        switch (breachType) {
            case TOO_LOW:
                System.out.printf("To: %s\n", recipient);
                System.out.println("Hi, the temperature is too low\n");
                break;
            case TOO_HIGH:
                System.out.printf("To: %s\n", recipient);
                System.out.println("Hi, the temperature is too high\n");
                break;
            case NORMAL:
                break;
        }
    }
}
