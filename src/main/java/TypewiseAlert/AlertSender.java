package TypewiseAlert;

public class AlertSender {
    public static void sendAlert(AlertTarget alertTarget, BreachType breachType) {
        if (alertTarget == AlertTarget.TO_CONTROLLER) {
            sendToController(breachType);
        } else if (alertTarget == AlertTarget.TO_EMAIL) {
            sendToEmail(breachType);
        } else {
            throw new IllegalArgumentException("Unknown AlertTarget");
        }
    }

    public static void sendToController(BreachType breachType) {
        int header = 0xfeed;
        System.out.printf("%i : %s\n", header, breachType);
    }

    public static void sendToEmail(BreachType breachType) {
        String recipient = "a.b@c.com";
        System.out.printf("To: %s\n%s", recipient, getEmailMessage(breachType));
    }

    public static String getEmailMessage(BreachType breachType) {
        switch (breachType) {
            case TOO_LOW:
                return "Hi, the temperature is too low\n";
            case TOO_HIGH:
                return "Hi, the temperature is too high\n";
            default:
                return "";
        }
    }
}
