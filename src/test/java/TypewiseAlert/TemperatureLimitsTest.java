package TypewiseAlert;

import static org.junit.Assert.*;
import org.junit.Test;

public class TemperatureLimitsTest {

    private static final double DELTA = 1e-15; // Tolerance for floating-point comparison

    @Test
    public void testGetLimits() {
        assertArrayEquals(new double[]{0.0, 35.0}, TemperatureLimits.getLimits(CoolingType.PASSIVE_COOLING), DELTA);
        assertArrayEquals(new double[]{0.0, 45.0}, TemperatureLimits.getLimits(CoolingType.HI_ACTIVE_COOLING), DELTA);
        assertArrayEquals(new double[]{0.0, 40.0}, TemperatureLimits.getLimits(CoolingType.MED_ACTIVE_COOLING), DELTA);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetLimitsUnknownType() {
        TemperatureLimits.getLimits(null); // Test with null or an invalid type if applicable
    }
}
