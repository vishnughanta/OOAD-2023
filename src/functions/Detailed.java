package functions;

import abstracts.Vehicle;
import enums.Cleanliness;
import enums.Condition;
import interfaces.RandomGenerator;
import interfaces.WashingMethod;

public class Detailed implements WashingMethod {
    private RandomGenerator randomGenerator;
    public Detailed() {
        randomGenerator = new RandomNumberGenerator();
    }
    @Override
    public void wash(Vehicle vehicle) {
        changeWashingStatus(vehicle);
    }

    private void changeWashingStatus(Vehicle vehicle) {
        int washingChance = randomGenerator.generateRandomNumber(0,100);
        if(vehicle.getCleanliness() == Cleanliness.DIRTY) {
            if(washingChance >=0 && washingChance < 60) vehicle.setCleanliness(Cleanliness.CLEAN);
            else if(washingChance >=60 && washingChance <80) vehicle.setCleanliness(Cleanliness.SPARKLING);
        }
        else if(vehicle.getCleanliness() == Cleanliness.CLEAN) {
            if(washingChance >= 0 && washingChance <5) vehicle.setCleanliness(Cleanliness.DIRTY);
            else if(washingChance >=5 && washingChance<45) vehicle.setCleanliness(Cleanliness.SPARKLING);
        }
    }
}
