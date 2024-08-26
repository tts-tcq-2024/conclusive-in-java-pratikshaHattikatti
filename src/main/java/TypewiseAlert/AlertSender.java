package TypewiseAlert;

public class AlertSender {
    public static void sendAlert(AlertTarget alertTarget, BreachType breachType) {
        switch (alertTarget) {
            case TO_CONTROLLER:
                sendToController(breachType);
                break;
            case TO_EMAIL:
                sendToEmail(breachType);
                break;
            default:
                throw new IllegalArgumentException("Unknown AlertTarget");
        }
    }

    private static void sendToController(BreachType breachType) {
        int header = 0xfeed;
        System.out.printf("%i : %s\n", header, breachType);
    }

    private static void sendToEmail(BreachType breachType) {
        String recipient = "a.b@c.com";
        String message = getEmailMessage(breachType);
        System.out.printf("To: %s\n%s", recipient, message);
    }

    private static String getEmailMessage(BreachType breachType) {
        switch (breachType) {
            case TOO_LOW:
                return "Hi, the temperature is too low\n";
            case TOO_HIGH:
                return "Hi, the temperature is too high\n";
            case NORMAL:
                return "";
            default:
                throw new IllegalArgumentException("Unknown BreachType");
        }
    }
}
