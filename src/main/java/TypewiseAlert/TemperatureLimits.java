package TypewiseAlert;

import java.util.HashMap;
import java.util.Map;

public class TemperatureLimits {

    private static final Map<CoolingType, int[]> LIMITS = new HashMap<>();

    static {
        LIMITS.put(CoolingType.PASSIVE_COOLING, new int[]{0, 35});
        LIMITS.put(CoolingType.HI_ACTIVE_COOLING, new int[]{0, 45});
        LIMITS.put(CoolingType.MED_ACTIVE_COOLING, new int[]{0, 40});
    }

    public static int[] getLimits(CoolingType coolingType) {
        int[] limits = LIMITS.get(coolingType);
        if (limits == null) {
            throw new IllegalArgumentException("Unknown cooling type");
        }
        return limits;
    }
}
