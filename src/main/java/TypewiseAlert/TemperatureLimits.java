package TypewiseAlert;

public class TemperatureLimits {
    public static int[] getLimits(CoolingType coolingType) {
        switch (coolingType) {
            case PASSIVE_COOLING:
                return new int[]{0, 35};
            case HI_ACTIVE_COOLING:
                return new int[]{0, 45};
            case MED_ACTIVE_COOLING:
                return new int[]{0, 40};
            default:
                throw new IllegalArgumentException("Unknown cooling type");
        }
    }
}
