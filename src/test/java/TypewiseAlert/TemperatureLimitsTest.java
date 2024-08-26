package TypewiseAlert;

import static org.junit.Assert.*;
import org.junit.Test;

public class TemperatureLimitsTest{

    @Test
    public void testGetLimits() {
        assertArrayEquals(new int[]{0, 35}, TemperatureLimits.getLimits(CoolingType.PASSIVE_COOLING));
        assertArrayEquals(new int[]{0, 45}, TemperatureLimits.getLimits(CoolingType.HI_ACTIVE_COOLING));
        assertArrayEquals(new int[]{0, 40}, TemperatureLimits.getLimits(CoolingType.MED_ACTIVE_COOLING));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetLimitsUnknownType() {
        TemperatureLimits.getLimits(null); // Test with null or an invalid type if applicable
    }
}
