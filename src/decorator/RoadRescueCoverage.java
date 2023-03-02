package decorator;

import abstracts.AddOnDecorator;
import abstracts.Vehicle;

public class RoadRescueCoverage extends AddOnDecorator {
    public RoadRescueCoverage(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public double getFinalPriceAfterAddOns() {
        setSalePrice(getSalePrice());
        return vehicle.getFinalPriceAfterAddOns() + vehicle.getSalePrice()*0.02;
    }
}
