package TypewiseAlert;

import static org.junit.Assert.*;
import org.junit.Test;

public class BreachClassifierTest {

    @Test
    public void testClassifyTemperatureBreach() {
        assertEquals(BreachType.TOO_LOW, BreachClassifier.classifyTemperatureBreach(CoolingType.PASSIVE_COOLING, -5));
        assertEquals(BreachType.TOO_HIGH, BreachClassifier.classifyTemperatureBreach(CoolingType.HI_ACTIVE_COOLING, 50));
        assertEquals(BreachType.NORMAL, BreachClassifier.classifyTemperatureBreach(CoolingType.MED_ACTIVE_COOLING, 30));
    }
}
