package vehicles;

import abstracts.Vehicle;
import enums.Cleanliness;
import enums.Condition;
import enums.VehicleType;
import functions.RandomNumberGenerator;

import java.util.Random;

public class Motorcycle extends Vehicle {
    protected double volumeSize;
    public Motorcycle() {

        randomNumberGenerator = new RandomNumberGenerator();
        this.name = "Motorcycle" + "-" + Vehicle.motorcycleNumber;
        this.costPrice = randomNumberGenerator.generateRandomNumber(10000,20000);
        int randomConditionNumber = randomNumberGenerator.generateRandomNumber(0,2);
        int randomCleanlinessNumber = randomNumberGenerator.generateRandomNumber(0,2);
        setWashBonus(50);
        setRepairBonus(70);
        setSalesBonus(90);
        setVehicleType(VehicleType.MOTORCYCLE);
        setVolumeSize(0);
        while(getVolumeSize() < 50) {
            setVolumeSize(calcVolumeSize(700,300));
        }

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

    /*
     * source: https://stackoverflow.com/questions/31754209/can-random-nextgaussian-sample-values-from-a-distribution-with-different-mean
     */
    private int calcVolumeSize(int mean, int stdDev) {
        Random randomNum = new Random();
        int mySample = (int)randomNum.nextGaussian() * stdDev + mean;
        return mySample;
    }

    public double getVolumeSize() {
        return volumeSize;
    }

    public void setVolumeSize(double volumeSize) {
        this.volumeSize = volumeSize;
    }
}
