import static org.junit.Assert.*;
import org.junit.Test;

public class TemperatureLimitsTest {

    @Test
    public void testGetLimits() {
        assertArrayEquals(new double[]{0, 35}, TemperatureLimits.getLimits(CoolingType.PASSIVE_COOLING), 0.01);
        assertArrayEquals(new double[]{0, 45}, TemperatureLimits.getLimits(CoolingType.HI_ACTIVE_COOLING), 0.01);
        assertArrayEquals(new double[]{0, 40}, TemperatureLimits.getLimits(CoolingType.MED_ACTIVE_COOLING), 0.01);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetLimitsUnknownCoolingType() {
        TemperatureLimits.getLimits(null); // Assuming null represents unknown CoolingType for the test
    }
}
