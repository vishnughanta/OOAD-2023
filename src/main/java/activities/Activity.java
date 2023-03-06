package main.java.activities;

import main.java.interfaces.RandomGenerator;
import main.java.abstracts.Staff;
import main.java.abstracts.Vehicle;
import main.java.interfaces.WashingMethod;
import main.java.printer.Printer;
import main.java.subscriber.SubscriberObject;

import java.util.ArrayList;
import java.util.List;

/*
This class is for initiating the activity on a whole.
Contains the common attributes for all the activities.
 */
public class Activity {
    protected RandomGenerator randomGenerator;
    protected String nameOfFNCD;
    protected double budget, dailySales;
    protected List<Staff> interns, salespersons, mechanics, drivers, departedStaff, dailyDepartingStaff;
    protected List<Vehicle> cars, pickups, performanceCars, electricCars, monsterTrucks, motorcycles, soldVehicles, dailySoldVehicles;
    protected WashingMethod washingMethod;
    protected SubscriberObject subscriberObject;
    protected Printer printer;


    public Activity(String nameOfFNCD) {
        setInterns(new ArrayList<>());
        setSalespersons(new ArrayList<>());
        setMechanics(new ArrayList<>());
        setDrivers(new ArrayList<>());
        setCars(new ArrayList<>());
        setPickups(new ArrayList<>());
        setPerformanceCars(new ArrayList<>());
        setElectricCars(new ArrayList<>());
        setMonsterTrucks(new ArrayList<>());
        setMotorcycles(new ArrayList<>());
        setSoldVehicles(new ArrayList<>());
        setDepartedStaff(new ArrayList<>());
        setDailyDepartingStaff(new ArrayList<>());
        setDailySoldVehicles(new ArrayList<>());
        setDailySales(0);
        setBudget(500000);
        setNameOfFNCD(nameOfFNCD);
    }

    protected void modifyOperatingBudget(Activity activity) {
        //add subscriber object
        System.out.println("Adding 250000 to the operating budget");
        double currentBudget = activity.getBudget();
        activity.setBudget(currentBudget + 250000);
    }

    public String getNameOfFNCD() {
        return nameOfFNCD;
    }

    public void setNameOfFNCD(String nameOfFNCD) {
        this.nameOfFNCD = nameOfFNCD;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public double getDailySales() {
        return dailySales;
    }

    public void setDailySales(double dailySales) {
        this.dailySales = dailySales;
    }

    public List<Staff> getInterns() {
        return interns;
    }

    public void setInterns(List<Staff> interns) {
        this.interns = interns;
    }

    public List<Staff> getSalespersons() {
        return salespersons;
    }

    public void setSalespersons(List<Staff> salespersons) {
        this.salespersons = salespersons;
    }

    public List<Staff> getMechanics() {
        return mechanics;
    }

    public void setMechanics(List<Staff> mechanics) {
        this.mechanics = mechanics;
    }

    public List<Staff> getDrivers() {
        return drivers;
    }

    public void setDrivers(List<Staff> drivers) {
        this.drivers = drivers;
    }

    public List<Staff> getDepartedStaff() {
        return departedStaff;
    }

    public void setDepartedStaff(List<Staff> departedStaff) {
        this.departedStaff = departedStaff;
    }

    public List<Staff> getDailyDepartingStaff() {
        return dailyDepartingStaff;
    }

    public void setDailyDepartingStaff(List<Staff> dailyDepartingStaff) {
        this.dailyDepartingStaff = dailyDepartingStaff;
    }

    public List<Vehicle> getCars() {
        return cars;
    }

    public void setCars(List<Vehicle> cars) {
        this.cars = cars;
    }

    public List<Vehicle> getPickups() {
        return pickups;
    }

    public void setPickups(List<Vehicle> pickups) {
        this.pickups = pickups;
    }

    public List<Vehicle> getPerformanceCars() {
        return performanceCars;
    }

    public void setPerformanceCars(List<Vehicle> performanceCars) {
        this.performanceCars = performanceCars;
    }

    public List<Vehicle> getElectricCars() {
        return electricCars;
    }

    public void setElectricCars(List<Vehicle> electricCars) {
        this.electricCars = electricCars;
    }

    public List<Vehicle> getMonsterTrucks() {
        return monsterTrucks;
    }

    public void setMonsterTrucks(List<Vehicle> monsterTrucks) {
        this.monsterTrucks = monsterTrucks;
    }

    public List<Vehicle> getMotorcycles() {
        return motorcycles;
    }

    public void setMotorcycles(List<Vehicle> motorcycles) {
        this.motorcycles = motorcycles;
    }

    public List<Vehicle> getSoldVehicles() {
        return soldVehicles;
    }

    public void setSoldVehicles(List<Vehicle> soldVehicles) {
        this.soldVehicles = soldVehicles;
    }

    public List<Vehicle> getDailySoldVehicles() {
        return dailySoldVehicles;
    }

    public void setDailySoldVehicles(List<Vehicle> dailySoldVehicles) {
        this.dailySoldVehicles = dailySoldVehicles;
    }

    public WashingMethod getWashingMethod() {
        return washingMethod;
    }

    public void setWashingMethod(WashingMethod washingMethod) {
        this.washingMethod = washingMethod;
    }

    public SubscriberObject getSubscriberObject() {
        return subscriberObject;
    }

    public void setSubscriberObject(SubscriberObject subscriberObject) {
        this.subscriberObject = subscriberObject;
    }
    public void updateStaffAmount(SubscriberObject subscriberObject, double amountToBeAdded) {
        double currStaffAmount = subscriberObject.getTotalMoneyStaff();
        subscriberObject.setTotalMoneyStaff(currStaffAmount + amountToBeAdded);
    }

    public void updateFNCDAmount(SubscriberObject subscriberObject, double amountToBeAdded) {
        double currFNCDAmount = subscriberObject.getTotalMoneyFNCD();
        subscriberObject.setTotalMoneyFNCD(currFNCDAmount + amountToBeAdded);
    }
}
