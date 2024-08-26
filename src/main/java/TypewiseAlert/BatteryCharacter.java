package TypewiseAlert;

public class BatteryCharacter {
    private CoolingType coolingType;
    private String brand;

    public BatteryCharacter(CoolingType coolingType, String brand) {
        this.coolingType = coolingType;
        this.brand = brand;
    }

    public CoolingType getCoolingType() {
        return coolingType;
    }

    public String getBrand() {
        return brand;
    }
}
