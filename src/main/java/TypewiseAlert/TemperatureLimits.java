package TypewiseAlert;

import java.util.HashMap;
import java.util.Map;

public class TemperatureLimits {

    private static final Map<CoolingType, double[]> LIMITS = new HashMap<>();

    static {
        LIMITS.put(CoolingType.PASSIVE_COOLING, new double[]{0.0, 35.0});
        LIMITS.put(CoolingType.HI_ACTIVE_COOLING, new double[]{0.0, 45.0});
        LIMITS.put(CoolingType.MED_ACTIVE_COOLING, new double[]{0.0, 40.0});
    }

    public static double[] getLimits(CoolingType coolingType) {
        double[] limits = LIMITS.get(coolingType);
        if (limits == null) {
            throw new IllegalArgumentException("Unknown cooling type");
        }
        return limits;
    }
}
