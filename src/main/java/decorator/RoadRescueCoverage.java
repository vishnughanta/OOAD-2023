package main.java.decorator;

import main.java.abstracts.AddOnDecorator;
import main.java.abstracts.Vehicle;

public class RoadRescueCoverage extends AddOnDecorator {
    public RoadRescueCoverage(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public double getFinalPriceAfterAddOns() {
        setSalePrice(getSalePrice());
        return vehicle.getFinalPriceAfterAddOns() + vehicle.getSalePrice()*0.02;
    }
}
