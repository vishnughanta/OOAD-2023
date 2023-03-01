package decorator;

import abstracts.AddOnDecorator;
import abstracts.Vehicle;

public class SatelliteRadio extends AddOnDecorator {
    public SatelliteRadio(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void assignFinalSalePriceAfterAddOns() {
        double initialSalePrice = vehicle.getSalePrice();
        vehicle.setFinalSalePrice(getFinalSalePrice() + initialSalePrice*0.05);
    }
}
