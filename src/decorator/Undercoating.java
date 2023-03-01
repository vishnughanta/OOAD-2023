package decorator;

import abstracts.AddOnDecorator;
import abstracts.Vehicle;

public class Undercoating extends AddOnDecorator {
    public Undercoating(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void assignFinalSalePriceAfterAddOns() {
        double initialSalePrice = vehicle.getSalePrice();
        vehicle.setFinalSalePrice(getFinalSalePrice() + initialSalePrice*0.05);
    }
}
