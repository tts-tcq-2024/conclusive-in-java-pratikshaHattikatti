package TypewiseAlert;

import static org.junit.Assert.*;
import org.junit.Test;

public class AlertSenderTest {

    @Test
    public void testGetEmailMessage() {
        assertEquals("Hi, the temperature is too low\n", AlertSender.getEmailMessage(BreachType.TOO_LOW));
        assertEquals("Hi, the temperature is too high\n", AlertSender.getEmailMessage(BreachType.TOO_HIGH));
        assertEquals("", AlertSender.getEmailMessage(BreachType.NORMAL));
    }
}
