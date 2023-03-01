package abstracts;
/*
This abstract class is the parent of all the types of Vehicles.
 */
import enums.Cleanliness;
import enums.Condition;
import enums.VehicleType;
import interfaces.NameGenerator;
import interfaces.RandomGenerator;


public abstract class Vehicle {
    public static int carNumber = 0;
    public static int performanceCarNumber = 0;
    public static int pickupNumber = 0;
    public static int motorcycleNumber = 0;
    public static int monsterTruckNumber = 0;
    public static int electricCarNumber = 0;
    private int racesWon;
    protected NameGenerator nameGenerator;
    protected RandomGenerator randomNumberGenerator;
    protected VehicleType vehicleType;
    protected String name;
    protected Condition condition;
    protected Cleanliness cleanliness;
    protected double washBonus;
    protected double repairBonus;
    protected double salesBonus;
    protected double costPrice;
    protected double salePrice;
    protected double finalSalePrice;

    /*
    Getters and setter methods
    This supports ENCAPSULATION.
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public Cleanliness getCleanliness() {
        return cleanliness;
    }

    public void setCleanliness(Cleanliness cleanliness) {
        this.cleanliness = cleanliness;
    }

    public double getWashBonus() {
        return washBonus;
    }

    public void setWashBonus(double washBonus) {
        this.washBonus = washBonus;
    }

    public double getRepairBonus() {
        return repairBonus;
    }

    public void setRepairBonus(double repairBonus) {
        this.repairBonus = repairBonus;
    }

    public double getSalesBonus() {
        return salesBonus;
    }

    public void setSalesBonus(double salesBonus) {
        this.salesBonus = salesBonus;
    }

    public double getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(double costPrice) {
        this.costPrice = costPrice;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public int getRacesWon() {
        return racesWon;
    }

    public void setRacesWon(int racesWon) {
        this.racesWon = racesWon;
    }

    public double getFinalSalePrice() {
        return finalSalePrice;
    }

    public void setFinalSalePrice(double finalSalePrice) {
        this.finalSalePrice = finalSalePrice;
    }
}
