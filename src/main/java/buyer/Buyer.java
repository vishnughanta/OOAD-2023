package buyer;

import abstracts.Buyers;
import enums.BuyingType;
import enums.VehicleType;
import functions.RandomNumberGenerator;

public class Buyer extends Buyers {
    public Buyer() {
        randomGenerator = new RandomNumberGenerator();
        int randomNumber = randomGenerator.generateRandomNumber(0,5);
        if(randomNumber == 0) this.vehicleType = VehicleType.CAR;
        else if(randomNumber == 1) this.vehicleType = VehicleType.PICKUP;
        else if(randomNumber==2) this.vehicleType = VehicleType.PERFORMANCE_CAR;
        else if(randomNumber == 3) this.vehicleType = VehicleType.ELECTRIC_CAR;
        else if(randomNumber == 4) this.vehicleType = VehicleType.MOTORCYCLE;
        else this.vehicleType = VehicleType.MONSTER_TRUCK;

        randomNumber = randomGenerator.generateRandomNumber(0,2);
        if(randomNumber == 0) this.buyingType = BuyingType.JUST_LOOKING;
        else if(randomNumber == 1) this.buyingType = BuyingType.WANTS_ONE;
        else this.buyingType = BuyingType.NEEDS_ONE;

    }
}
