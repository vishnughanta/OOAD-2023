package main.java.activities;

import main.java.abstracts.Staff;
import main.java.abstracts.Vehicle;
import main.java.functions.Graph;
import main.java.subscriber.SubscriberObject;

import java.lang.management.GarbageCollectorMXBean;
import java.util.ArrayList;
import java.util.List;

/*
This class is for initiating the activity on a whole.
Contains the common attributes for all the activities.
 */
public class Activity {
    private String nameOfFNCD;
    private double budget, dailySales;
    private static int carID, pickupID, performanceCarID, electricCarID, motorcycleID, monsterTruckID, coupeID, minivanID, SUVID;
    private static int internID, mechanicID, salespersonID, driverID;
    private List<Staff> interns, salespersons, mechanics, drivers, departedStaff, dailyDepartingStaff;
    private List<Vehicle> cars, pickups, performanceCars, electricCars, monsterTrucks, motorcycles, coupes, minivans, suvs;
    private List<Vehicle> soldVehicles, dailySoldVehicles;
    private SubscriberObject subscriberObject;
    private Graph graph;

    public void startActivity(String nameOfFNCD) {
        setID();
        setStaff();
        setVehicle();
        setDailyActivities();
        setDeparted();
        setDailySales(0);
        setBudget(500000);
        setSubscriberObject(new SubscriberObject());
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

    public static int getCarID() {
        return carID;
    }

    public static void setCarID(int carID) {
        Activity.carID = carID;
    }

    public static int getPickupID() {
        return pickupID;
    }

    public static void setPickupID(int pickupID) {
        Activity.pickupID = pickupID;
    }

    public static int getPerformanceCarID() {
        return performanceCarID;
    }

    public static void setPerformanceCarID(int performanceCarID) {
        Activity.performanceCarID = performanceCarID;
    }

    public static int getElectricCarID() {
        return electricCarID;
    }

    public static void setElectricCarID(int electricCarID) {
        Activity.electricCarID = electricCarID;
    }

    public static int getMotorcycleID() {
        return motorcycleID;
    }

    public static void setMotorcycleID(int motorcycleID) {
        Activity.motorcycleID = motorcycleID;
    }

    public static int getMonsterTruckID() {
        return monsterTruckID;
    }

    public static void setMonsterTruckID(int monsterTruckID) {
        Activity.monsterTruckID = monsterTruckID;
    }

    public static int getCoupeID() {
        return coupeID;
    }

    public static void setCoupeID(int coupeID) {
        Activity.coupeID = coupeID;
    }

    public static int getMinivanID() {
        return minivanID;
    }

    public static void setMinivanID(int minivanID) {
        Activity.minivanID = minivanID;
    }

    public static int getSUVID() {
        return SUVID;
    }

    public static void setSUVID(int SUVID) {
        Activity.SUVID = SUVID;
    }

    public static int getInternID() {
        return internID;
    }

    public static void setInternID(int internID) {
        Activity.internID = internID;
    }

    public static int getMechanicID() {
        return mechanicID;
    }

    public static void setMechanicID(int mechanicID) {
        Activity.mechanicID = mechanicID;
    }

    public static int getSalespersonID() {
        return salespersonID;
    }

    public static void setSalespersonID(int salespersonID) {
        Activity.salespersonID = salespersonID;
    }

    public static int getDriverID() {
        return driverID;
    }

    public static void setDriverID(int driverID) {
        Activity.driverID = driverID;
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

    public Graph getGraph() {
        return graph;
    }

    public void setGraph(Graph graph) {
        this.graph = graph;
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
