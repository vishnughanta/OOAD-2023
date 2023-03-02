package decorator;

import abstracts.AddOnDecorator;
import abstracts.Vehicle;

public class SatelliteRadio extends AddOnDecorator {
    public SatelliteRadio(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public double getFinalPriceAfterAddOns() {
        setSalePrice(getSalePrice());
        return vehicle.getFinalPriceAfterAddOns() + vehicle.getSalePrice()*0.05;
    }
}
