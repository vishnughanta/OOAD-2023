package vehicles;

import abstracts.Vehicle;
import enums.Cleanliness;
import enums.Condition;
import enums.VehicleType;
import functions.RandomNumberGenerator;

public class ElectricCar extends Vehicle {
    protected double range;

    public ElectricCar() {
        this.range = randomNumberGenerator.generateRandomNumber(60, 400);
        randomNumberGenerator = new RandomNumberGenerator();
        this.name = "Electric Car" + "-" + Vehicle.carNumber;
        this.costPrice = randomNumberGenerator.generateRandomNumber(10000,20000);
        int randomConditionNumber = randomNumberGenerator.generateRandomNumber(0,2);
        int randomCleanlinessNumber = randomNumberGenerator.generateRandomNumber(0,2);
        washBonus = 100;
        repairBonus = 200;
        salesBonus = 300;
        vehicleType = VehicleType.ELECTRIC_CAR;

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

        if(randomCleanlinessNumber == 0) {
            cleanliness = Cleanliness.SPARKLING;
        } else if (randomCleanlinessNumber == 1) {
            cleanliness = Cleanliness.CLEAN;
        } else {
            cleanliness = Cleanliness.DIRTY;
        }
    }
}
