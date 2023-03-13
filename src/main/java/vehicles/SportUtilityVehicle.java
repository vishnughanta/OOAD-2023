package main.java.vehicles;

import main.java.abstracts.Vehicle;
import main.java.activities.Activity;
import main.java.enums.Cleanliness;
import main.java.enums.Condition;
import main.java.enums.VehicleType;
import main.java.functions.RandomNumberGenerator;

public class SportUtilityVehicle extends Vehicle {
    public SportUtilityVehicle(Activity activity) {
        randomNumberGenerator = new RandomNumberGenerator();
        this.name = "SUV" + "-" + activity.getSUVID();
        activity.setSUVID(activity.getSUVID() + 1);
        this.costPrice = randomNumberGenerator.generateRandomNumber(10000,20000);
        int randomConditionNumber = randomNumberGenerator.generateRandomNumber(0,2);
        int randomCleanlinessNumber = randomNumberGenerator.generateRandomNumber(0,2);
        setWashBonus(50);
        setRepairBonus(70);
        setSalesBonus(90);
        setVehicleType(VehicleType.SPORT_UTILITY_VEHICLE);


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
