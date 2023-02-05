package abstracts;

import enums.BuyingType;
import enums.VehicleType;
import interfaces.RandomGenerator;

public class Buyers {
    protected BuyingType buyingType;
    protected VehicleType vehicleType;
    protected RandomGenerator randomGenerator;

    public BuyingType getBuyingType() {
        return buyingType;
    }

    public void setBuyingType(BuyingType buyingType) {
        this.buyingType = buyingType;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
}
