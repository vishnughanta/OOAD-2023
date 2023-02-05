package vehicles;

import enums.Cleanliness;
import enums.Condition;
import interfaces.NameGenerator;
import interfaces.RandomGenerator;


abstract class Vehicle {
    protected NameGenerator nameGenerator;
    protected RandomGenerator randomNumberGenerator;
    protected String name;
    protected Condition condition;
    protected Cleanliness cleanliness;
    protected double washBonus;
    protected double repairBonus;
    protected double salesBonus;
    protected double costPrice;
    protected double salePrice;

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
}
