package TypewiseAlert;

public class TemperatureLimits {
    public static double[] getLimits(CoolingType coolingType) {
        double lowerLimit;
        double upperLimit;

        switch (coolingType) {
            case PASSIVE_COOLING:
                lowerLimit = 0;
                upperLimit = 35;
                break;
            case HI_ACTIVE_COOLING:
                lowerLimit = 0;
                upperLimit = 45;
                break;
            case MED_ACTIVE_COOLING:
                lowerLimit = 0;
                upperLimit = 40;
                break;
            default:
                throw new IllegalArgumentException("Unknown CoolingType");
        }
        return new double[]{lowerLimit, upperLimit};
    }
}
