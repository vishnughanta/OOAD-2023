package main.java.activities;

import main.java.abstracts.Staff;
import main.java.abstracts.Vehicle;
import main.java.subscriber.SubscriberObject;

import java.util.ArrayList;
import java.util.List;

/*
This class is for initiating the activity on a whole.
Contains the common attributes for all the activities.
 */
public class Activity {
    private String nameOfFNCD;
    private double budget, dailySales;
    private int carID, pickupID, performanceCarID, electricCarID, motorcycleID, monsterTruckID, coupeID, minivanID, SUVID;
    private int internID, mechanicID, salespersonID, driverID;
    private List<Staff> interns, salespersons, mechanics, drivers, departedStaff, dailyDepartingStaff;
    private List<Vehicle> cars, pickups, performanceCars, electricCars, monsterTrucks, motorcycles, coupes, minivans, suvs;
    private List<Vehicle> soldVehicles, dailySoldVehicles;
    private SubscriberObject subscriberObject;

    public void startActivity(String nameOfFNCD) {
        setID();
        setStaff();
        setVehicle();
        setDailyActivities();
        setDeparted();
        setDailySales(0);
        setBudget(500000);
        setNameOfFNCD(nameOfFNCD);
    }

    private void setDeparted() {
        setSoldVehicles(new ArrayList<>());
        setDepartedStaff(new ArrayList<>());
    }

    private void setDailyActivities() {
        setDailyDepartingStaff(new ArrayList<>());
        setDailySoldVehicles(new ArrayList<>());
    }

    private void setVehicle() {
        setCars(new ArrayList<>());
        setPickups(new ArrayList<>());
        setPerformanceCars(new ArrayList<>());
        setElectricCars(new ArrayList<>());
        setMonsterTrucks(new ArrayList<>());
        setMotorcycles(new ArrayList<>());
        setCoupes(new ArrayList<>());
        setMinivans(new ArrayList<>());
        setSuvs(new ArrayList<>());
    }

    private void setStaff() {
        setInterns(new ArrayList<>());
        setSalespersons(new ArrayList<>());
        setMechanics(new ArrayList<>());
        setDrivers(new ArrayList<>());
    }

    private void setID() {
        setCarID(1);
        setPickupID(1);
        setPerformanceCarID(1);
        setElectricCarID(1);
        setMotorcycleID(1);
        setMonsterTruckID(1);
        setCoupeID(1);
        setMinivanID(1);
        setSUVID(1);
        setInternID(1);
        setMechanicID(1);
        setSalespersonID(1);
        setDriverID(1);
    }

    protected void modifyOperatingBudget(Activity activity) {
        //add subscriber object
        System.out.println("Adding 250000 to the operating budget");
        double currentBudget = activity.getBudget();
        activity.setBudget(currentBudget + 250000);
    }

    public int getCarID() {
        return carID;
    }

    public void setCarID(int carID) {
        this.carID = carID;
    }

    public int getPickupID() {
        return pickupID;
    }

    public void setPickupID(int pickupID) {
        this.pickupID = pickupID;
    }

    public int getPerformanceCarID() {
        return performanceCarID;
    }

    public void setPerformanceCarID(int performanceCarID) {
        this.performanceCarID = performanceCarID;
    }

    public int getElectricCarID() {
        return electricCarID;
    }

    public void setElectricCarID(int electricCarID) {
        this.electricCarID = electricCarID;
    }

    public int getMotorcycleID() {
        return motorcycleID;
    }

    public void setMotorcycleID(int motorcycleID) {
        this.motorcycleID = motorcycleID;
    }

    public int getMonsterTruckID() {
        return monsterTruckID;
    }

    public void setMonsterTruckID(int monsterTruckID) {
        this.monsterTruckID = monsterTruckID;
    }

    public int getCoupeID() {
        return coupeID;
    }

    public void setCoupeID(int coupeID) {
        this.coupeID = coupeID;
    }

    public int getMinivanID() {
        return minivanID;
    }

    public void setMinivanID(int minivanID) {
        this.minivanID = minivanID;
    }

    public int getSUVID() {
        return SUVID;
    }

    public void setSUVID(int SUVID) {
        this.SUVID = SUVID;
    }

    public int getInternID() {
        return internID;
    }

    public void setInternID(int internID) {
        this.internID = internID;
    }

    public int getMechanicID() {
        return mechanicID;
    }

    public void setMechanicID(int mechanicID) {
        this.mechanicID = mechanicID;
    }

    public int getSalespersonID() {
        return salespersonID;
    }

    public void setSalespersonID(int salespersonID) {
        this.salespersonID = salespersonID;
    }

    public int getDriverID() {
        return driverID;
    }

    public void setDriverID(int driverID) {
        this.driverID = driverID;
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

    public List<Vehicle> getCoupes() {
        return coupes;
    }

    public void setCoupes(List<Vehicle> coupes) {
        this.coupes = coupes;
    }

    public List<Vehicle> getMinivans() {
        return minivans;
    }

    public void setMinivans(List<Vehicle> minivans) {
        this.minivans = minivans;
    }

    public List<Vehicle> getSuvs() {
        return suvs;
    }

    public void setSuvs(List<Vehicle> suvs) {
        this.suvs = suvs;
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
