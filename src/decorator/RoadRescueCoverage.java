package decorator;

import abstracts.AddOnDecorator;
import abstracts.Vehicle;

public class RoadRescueCoverage extends AddOnDecorator {
    public RoadRescueCoverage(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void assignFinalSalePriceAfterAddOns() {
        double initialSalePrice = vehicle.getSalePrice();
        vehicle.setFinalSalePrice(getFinalSalePrice() + initialSalePrice*0.02);
    }
}
