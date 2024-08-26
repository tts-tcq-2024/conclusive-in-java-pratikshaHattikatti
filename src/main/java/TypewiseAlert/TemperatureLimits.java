package TypewiseAlert;

import java.util.HashMap;
import java.util.Map;

public class TemperatureLimits {

    private static final Map<CoolingType, double[]> limitsMap = new HashMap<>();

    static {
        limitsMap.put(CoolingType.PASSIVE_COOLING, new double[]{0, 35});
        limitsMap.put(CoolingType.HI_ACTIVE_COOLING, new double[]{0, 45});
        limitsMap.put(CoolingType.MED_ACTIVE_COOLING, new double[]{0, 40});
    }

    public static double[] getLimits(CoolingType coolingType) {
        if (limitsMap.containsKey(coolingType)) {
            return limitsMap.get(coolingType);
        } else {
            throw new IllegalArgumentException("Unknown CoolingType");
        }
    }
}
