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

import static org.junit.Assert.*;
import org.junit.Test;

public class AlertSenderTest {

    @Test
    public void testSendToController() {
        // Redirect stdout to capture output for testing
        java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outContent));

        AlertSender.sendAlert(AlertTarget.TO_CONTROLLER, BreachType.TOO_LOW);
        assertTrue(outContent.toString().contains("feed : TOO_LOW"));

        System.setOut(System.out); // Reset System.out
    }

    @Test
    public void testSendToEmail() {
        // Redirect stdout to capture output for testing
        java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outContent));

        AlertSender.sendAlert(AlertTarget.TO_EMAIL, BreachType.TOO_HIGH);
        assertTrue(outContent.toString().contains("Hi, the temperature is too high"));

        System.setOut(System.out); // Reset System.out
    }
}
