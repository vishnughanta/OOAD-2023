package main.java.abstracts;
/*
This abstract class is for the common features in Buyer class.
This will help to scale when there are more than 1 type of buyers.
 */
import main.java.enums.BuyingType;
import main.java.enums.VehicleType;
import main.java.interfaces.RandomGenerator;

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
