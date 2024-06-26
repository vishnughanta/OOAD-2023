package activities;

import interfaces.RandomGenerator;
import abstracts.Staff;
import abstracts.Vehicle;
import printer.Printer;

import java.util.ArrayList;
import java.util.List;

/*
This class is for initiating the activity on a whole.
Contains the common attributes for all the activities.
 */
public class Activity {
    private static double budget;
    protected RandomGenerator randomGenerator;
    protected static List<Staff> interns;
    protected static List<Staff> salespersons;
    protected static List<Staff> mechanics;
    protected static List<Vehicle> cars;
    protected static List<Vehicle> pickups;
    protected static List<Vehicle> performanceCars;
    protected static List<Vehicle> soldVehicles;
    protected static List<Staff> departedStaff;
    protected static List<Staff> dailyDepartingStaff;
    protected static List<Vehicle> dailySoldVehicles;
    protected static double dailySales;
    protected Printer printer;

    static {
        interns = new ArrayList<>();
        salespersons = new ArrayList<>();
        mechanics = new ArrayList<>();
        cars = new ArrayList<>();
        pickups = new ArrayList<>();
        performanceCars = new ArrayList<>();
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
}
