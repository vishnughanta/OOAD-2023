package main.java.functions;

import main.java.abstracts.Vehicle;
import main.java.enums.Cleanliness;
import main.java.enums.Condition;
import main.java.interfaces.RandomGenerator;
import main.java.interfaces.WashingMethod;

public class ElbowGrease implements WashingMethod {
    private RandomGenerator randomGenerator;
    public ElbowGrease() {
        randomGenerator = new RandomNumberGenerator();
    }
    @Override
    public void wash(Vehicle vehicle) {
        changeWashingStatus(vehicle);
        changeConditionStatus(vehicle);
    }

    private void changeConditionStatus(Vehicle vehicle) {
        int brokenChance = randomGenerator.generateRandomNumber(0,100);
        if(vehicle.getCondition() != Condition.NEW) {
            if(brokenChance <= 10) {
                vehicle.setCondition(Condition.NEW);
            }
        }
    }

    private void changeWashingStatus(Vehicle vehicle) {
        int washingChance = randomGenerator.generateRandomNumber(0,100);
        if(vehicle.getCleanliness() == Cleanliness.DIRTY) {
            if(washingChance >=0 && washingChance < 70) vehicle.setCleanliness(Cleanliness.CLEAN);
            else if(washingChance >=70 && washingChance <75) vehicle.setCleanliness(Cleanliness.SPARKLING);
        }
        else if(vehicle.getCleanliness() == Cleanliness.CLEAN) {
            if(washingChance >= 0 && washingChance <15) vehicle.setCleanliness(Cleanliness.DIRTY);
            else if(washingChance >=15 && washingChance<30) vehicle.setCleanliness(Cleanliness.SPARKLING);
        }
    }
}
