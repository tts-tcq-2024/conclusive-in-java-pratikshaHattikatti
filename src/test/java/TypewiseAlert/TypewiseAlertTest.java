import static org.junit.Assert.*;
import org.junit.Test;

public class TypewiseAlertTest {

    @Test
    public void testInferBreach() {
        assertEquals(TypewiseAlert.BreachType.TOO_LOW, TypewiseAlert.inferBreach(-5, 0, 35));
        assertEquals(TypewiseAlert.BreachType.TOO_HIGH, TypewiseAlert.inferBreach(50, 0, 35));
        assertEquals(TypewiseAlert.BreachType.NORMAL, TypewiseAlert.inferBreach(20, 0, 35));
    }

    @Test
    public void testClassifyTemperatureBreach() {
        assertEquals(TypewiseAlert.BreachType.TOO_LOW, TypewiseAlert.classifyTemperatureBreach(TypewiseAlert.CoolingType.PASSIVE_COOLING, -5));
        assertEquals(TypewiseAlert.BreachType.TOO_HIGH, TypewiseAlert.classifyTemperatureBreach(TypewiseAlert.CoolingType.HI_ACTIVE_COOLING, 50));
        assertEquals(TypewiseAlert.BreachType.NORMAL, TypewiseAlert.classifyTemperatureBreach(TypewiseAlert.CoolingType.MED_ACTIVE_COOLING, 30));
    }

    @Test
    public void testCheckAndAlert() {
        TypewiseAlert.BatteryCharacter batteryChar = new TypewiseAlert().new BatteryCharacter();
        batteryChar.coolingType = TypewiseAlert.CoolingType.PASSIVE_COOLING;

        // Redirect stdout to capture output for testing
        java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outContent));

        TypewiseAlert.checkAndAlert(TypewiseAlert.AlertTarget.TO_CONTROLLER, batteryChar, -5);
        assertTrue(outContent.toString().contains("feed : TOO_LOW"));

        outContent.reset();
        TypewiseAlert.checkAndAlert(TypewiseAlert.AlertTarget.TO_EMAIL, batteryChar, 50);
        assertTrue(outContent.toString().contains("Hi, the temperature is too high"));

        System.setOut(System.out); // Reset System.out
    }
}
