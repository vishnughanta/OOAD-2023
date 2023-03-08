package main.java.vehicles;
/*
This class is for attributes of the Pickup type.
 */
import main.java.abstracts.Vehicle;
import main.java.activities.Activity;
import main.java.enums.Cleanliness;
import main.java.enums.Condition;
import main.java.enums.VehicleType;
import main.java.functions.RandomNumberGenerator;
import main.java.functions.VehicleName;
import main.java.interfaces.RandomGenerator;

public class Pickup extends Vehicle {
    public Pickup(Activity activity) {
        randomNumberGenerator = new RandomNumberGenerator();
        this.name = "Pickup" + "-" + activity.getPickupID();
        activity.setPickupID(activity.getPickupID() + 1);
        this.costPrice = randomNumberGenerator.generateRandomNumber(10000,40000);
        int randomConditionNumber = randomNumberGenerator.generateRandomNumber(0,2);
        int randomCleanlinessNumber = randomNumberGenerator.generateRandomNumber(1,100);
        washBonus = 100;
        repairBonus = 200;
        salesBonus = 300;
        vehicleType = VehicleType.PICKUP;

        if(randomConditionNumber == 0) {
            setCondition(Condition.NEW);
        } else if (randomConditionNumber == 1) {
            setCondition(Condition.USED);
            setCostPrice(getCostPrice()*0.8);
        } else{
            setCondition(Condition.BROKEN);
            setCostPrice(getCostPrice()*0.5);
        }

        this.salePrice = 2 * costPrice;

        if(randomCleanlinessNumber == 0) {
            setCleanliness(Cleanliness.SPARKLING);
        } else if (randomCleanlinessNumber == 1) {
            setCleanliness(Cleanliness.CLEAN);
        } else {
            setCleanliness(Cleanliness.DIRTY);
        }

         setRacesWon(0);
         setFinalSalePrice(getSalePrice());
    }
}
