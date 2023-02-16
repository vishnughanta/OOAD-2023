package vehicles;
/*
This class is for attributes of the Pickup type.
 */
import abstracts.Vehicle;
import enums.Cleanliness;
import enums.Condition;
import enums.VehicleType;
import functions.RandomNumberGenerator;
import functions.VehicleName;

public class Pickup extends Vehicle {
    public Pickup() {
        nameGenerator = new VehicleName();
        randomNumberGenerator = new RandomNumberGenerator();
        this.name = "Pickup" + "-" + Vehicle.pickupNumber;
        this.costPrice = randomNumberGenerator.generateRandomNumber(10000,40000);
        int randomConditionNumber = randomNumberGenerator.generateRandomNumber(0,2);
        int randomCleanlinessNumber = randomNumberGenerator.generateRandomNumber(1,100);
        washBonus = 100;
        repairBonus = 200;
        salesBonus = 300;
        vehicleType = VehicleType.PICKUP;

        if(randomConditionNumber == 0) {
            condition = Condition.NEW;
        } else if (randomConditionNumber == 1) {
            condition = Condition.USED;
            costPrice = costPrice * 0.8;
        } else{
            condition = Condition.BROKEN;
            costPrice = costPrice/2;
        }

        this.salePrice = 2 * costPrice;

        if(randomCleanlinessNumber >=1 && randomCleanlinessNumber <=5) {
            cleanliness = Cleanliness.SPARKLING;
        } else if (randomCleanlinessNumber > 5 && randomCleanlinessNumber <=40 )  {
            cleanliness = Cleanliness.CLEAN;
        } else {
            cleanliness = Cleanliness.DIRTY;
        }
    }
}
