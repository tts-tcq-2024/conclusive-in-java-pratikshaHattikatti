package TypewiseAlert;

public class TypewiseAlert {



    public static void checkAndAlert(AlertTarget alertTarget, BatteryCharacter batteryChar, double temperatureInC) {
        BreachType breachType = BreachClassifier.classifyTemperatureBreach(
            batteryChar.getCoolingType(), temperatureInC
        );

        switch (alertTarget) {
            case TO_CONTROLLER:
                AlertSender.sendToController(breachType);
                break;
            case TO_EMAIL:
                AlertSender.sendToEmail(breachType);
                break;
        }
    }
}
