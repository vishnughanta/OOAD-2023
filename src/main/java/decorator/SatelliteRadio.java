package main.java.decorator;

import main.java.abstracts.AddOnDecorator;
import main.java.abstracts.Vehicle;

public class SatelliteRadio extends AddOnDecorator {
    public SatelliteRadio(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public double getFinalPriceAfterAddOns() {
        setSalePrice(getSalePrice());
        return vehicle.getFinalPriceAfterAddOns() + vehicle.getSalePrice()*0.05;
    }
}
