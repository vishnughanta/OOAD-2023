package buyer;

import abstracts.Buyers;
import enums.VehicleType;
import functions.RandomNumberGenerator;

public class Buyer extends Buyers {
    public Buyer() {
        randomGenerator = new RandomNumberGenerator();
        int randomNumber = randomGenerator.generateRandomNumber(0,2);
        if(randomNumber == 0) this.vehicleType = VehicleType.CAR;
        else if(randomNumber == 1) this.vehicleType = VehicleType.PICKUP;
        else this.vehicleType = VehicleType.PERFORMANCE_CAR;
    }
}
