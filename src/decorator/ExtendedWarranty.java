package decorator;

import abstracts.AddOnDecorator;
import abstracts.Vehicle;

public class ExtendedWarranty extends AddOnDecorator {
    public ExtendedWarranty(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void assignFinalSalePriceAfterAddOns() {
        double initialSalePrice = vehicle.getSalePrice();
        vehicle.setFinalSalePrice(getFinalSalePrice() + initialSalePrice*0.2);
    }
}
