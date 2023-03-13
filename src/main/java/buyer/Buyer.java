package main.java.buyer;

import main.java.abstracts.Buyers;
import main.java.enums.BuyingType;
import main.java.enums.VehicleType;
import main.java.functions.RandomNumberGenerator;

public class Buyer extends Buyers {
    public Buyer() {
        randomGenerator = new RandomNumberGenerator();
        int randomNumber = randomGenerator.generateRandomNumber(0,8);
        if(randomNumber == 0) this.vehicleType = VehicleType.CAR;
        else if(randomNumber == 1) this.vehicleType = VehicleType.PICKUP;
        else if(randomNumber==2) this.vehicleType = VehicleType.PERFORMANCE_CAR;
        else if(randomNumber == 3) this.vehicleType = VehicleType.ELECTRIC_CAR;
        else if(randomNumber == 4) this.vehicleType = VehicleType.MOTORCYCLE;
        else if(randomNumber == 5) this.vehicleType = VehicleType.MONSTER_TRUCK;
        else if(randomNumber == 6) this.vehicleType = VehicleType.COUPE;
        else if(randomNumber == 7) this.vehicleType = VehicleType.MINIVAN;
        else this.vehicleType = VehicleType.SPORT_UTILITY_VEHICLE;

        randomNumber = randomGenerator.generateRandomNumber(0,2);
        if(randomNumber == 0) this.buyingType = BuyingType.JUST_LOOKING;
        else if(randomNumber == 1) this.buyingType = BuyingType.WANTS_ONE;
        else this.buyingType = BuyingType.NEEDS_ONE;

    }
}
