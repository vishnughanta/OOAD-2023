package vehicles;

import enums.Cleanliness;
import enums.Condition;
import functions.RandomNumberGenerator;
import functions.VehicleName;

public class Car extends Vehicle {
    public Car() {
        nameGenerator = new VehicleName();
        randomNumberGenerator = new RandomNumberGenerator();
        this.name = nameGenerator.generateName();
        this.costPrice = randomNumberGenerator.generateRandomNumber(10000,20000);
        int randomConditionNumber = randomNumberGenerator.generateRandomNumber(0,2);
        int randomCleanlinessNumber = randomNumberGenerator.generateRandomNumber(0,2);
        washBonus = 100;
        repairBonus = 200;
        salesBonus = 300;

        if(randomConditionNumber == 0) {
            condition = Condition.NEW;
        } else if (randomConditionNumber == 1) {
            condition = Condition.USED;
            costPrice -= costPrice * 0.2;
        } else{
            condition = Condition.BROKEN;
            costPrice = costPrice/2;
        }

        if(randomCleanlinessNumber == 0) {
            cleanliness = Cleanliness.SPARKLING;
        } else if (randomCleanlinessNumber == 1) {
            cleanliness = Cleanliness.CLEAN;
        } else {
            cleanliness = Cleanliness.DIRTY;
        }
    }
}
