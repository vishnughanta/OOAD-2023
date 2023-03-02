package activities;

import interfaces.RandomGenerator;
import abstracts.Staff;
import abstracts.Vehicle;
import interfaces.WashingMethod;
import printer.Printer;
import subscriber.SubscriberObject;

import java.util.ArrayList;
import java.util.List;

/*
This class is for initiating the activity on a whole.
Contains the common attributes for all the activities.
 */
public class Activity {
    protected RandomGenerator randomGenerator;
    protected static double budget, dailySales;
    protected static List<Staff> interns, salespersons, mechanics, drivers, departedStaff, dailyDepartingStaff;
    protected static List<Vehicle> cars, pickups, performanceCars, electricCars, monsterTrucks, motorcycles, soldVehicles, dailySoldVehicles;
    protected WashingMethod washingMethod;
    protected static SubscriberObject subscriberObject;
    protected Printer printer;

    static {
        interns = new ArrayList<>();
        salespersons = new ArrayList<>();
        mechanics = new ArrayList<>();
        drivers = new ArrayList<>();
        cars = new ArrayList<>();
        pickups = new ArrayList<>();
        performanceCars = new ArrayList<>();
        electricCars = new ArrayList<>();
        monsterTrucks = new ArrayList<>();
        motorcycles = new ArrayList<>();
        soldVehicles = new ArrayList<>();
        departedStaff = new ArrayList<>();
        dailyDepartingStaff = new ArrayList<>();
        dailySoldVehicles = new ArrayList<>();
        dailySales = 0;
        budget = 500000;
    }

    public Activity() {

    }

    protected static double getBudget() {
        return budget;
    }

    protected static void setBudget(double budget) {
        Activity.budget = budget;
    }

    protected void modifyOperatingBudget() {
        System.out.println("Adding 250000 to the operating budget");
        Activity.budget += 250000;
    }

    public static double getDailySales() {
        return dailySales;
    }

    public static void setDailySales(double dailySales) {
        Activity.dailySales = dailySales;
    }

    public static List<Staff> getInterns() {
        return interns;
    }

    public static void setInterns(List<Staff> interns) {
        Activity.interns = interns;
    }

    public static List<Staff> getSalespersons() {
        return salespersons;
    }

    public static void setSalespersons(List<Staff> salespersons) {
        Activity.salespersons = salespersons;
    }

    public static List<Staff> getMechanics() {
        return mechanics;
    }

    public static void setMechanics(List<Staff> mechanics) {
        Activity.mechanics = mechanics;
    }

    public static List<Staff> getDrivers() {
        return drivers;
    }

    public static void setDrivers(List<Staff> drivers) {
        Activity.drivers = drivers;
    }

    public static List<Vehicle> getCars() {
        return cars;
    }

    public static void setCars(List<Vehicle> cars) {
        Activity.cars = cars;
    }

    public static List<Vehicle> getPickups() {
        return pickups;
    }

    public static void setPickups(List<Vehicle> pickups) {
        Activity.pickups = pickups;
    }

    public static List<Vehicle> getPerformanceCars() {
        return performanceCars;
    }

    public static void setPerformanceCars(List<Vehicle> performanceCars) {
        Activity.performanceCars = performanceCars;
    }

    public static List<Vehicle> getElectricCars() {
        return electricCars;
    }

    public static void setElectricCars(List<Vehicle> electricCars) {
        Activity.electricCars = electricCars;
    }

    public static List<Vehicle> getMonsterTrucks() {
        return monsterTrucks;
    }

    public static void setMonsterTrucks(List<Vehicle> monsterTrucks) {
        Activity.monsterTrucks = monsterTrucks;
    }

    public static List<Vehicle> getMotorcycles() {
        return motorcycles;
    }

    public static void setMotorcycles(List<Vehicle> motorcycles) {
        Activity.motorcycles = motorcycles;
    }

    public static List<Vehicle> getSoldVehicles() {
        return soldVehicles;
    }

    public static void setSoldVehicles(List<Vehicle> soldVehicles) {
        Activity.soldVehicles = soldVehicles;
    }

    public static List<Staff> getDepartedStaff() {
        return departedStaff;
    }

    public static void setDepartedStaff(List<Staff> departedStaff) {
        Activity.departedStaff = departedStaff;
    }

    public static List<Staff> getDailyDepartingStaff() {
        return dailyDepartingStaff;
    }

    public static void setDailyDepartingStaff(List<Staff> dailyDepartingStaff) {
        Activity.dailyDepartingStaff = dailyDepartingStaff;
    }

    public static List<Vehicle> getDailySoldVehicles() {
        return dailySoldVehicles;
    }

    public static void setDailySoldVehicles(List<Vehicle> dailySoldVehicles) {
        Activity.dailySoldVehicles = dailySoldVehicles;
    }

    public static SubscriberObject getSubscriberObject() {
        return subscriberObject;
    }

    public static void setSubscriberObject(SubscriberObject subscriberObject) {
        Activity.subscriberObject = subscriberObject;
    }
}
