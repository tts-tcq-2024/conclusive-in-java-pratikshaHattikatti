package TypewiseAlert;

public class TypewiseAlert {
    public static void checkAndAlert(AlertTarget alertTarget, BatteryCharacter batteryChar, double temperatureInC) {
        BreachType breachType = BreachClassifier.classifyTemperatureBreach(
            batteryChar.getCoolingType(), temperatureInC
        );
        AlertSender.sendAlert(alertTarget, breachType);
    }
}
