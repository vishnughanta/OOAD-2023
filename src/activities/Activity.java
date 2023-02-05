package activities;

import staff.Intern;
import staff.Mechanic;
import staff.Salesperson;
import vehicles.Car;
import vehicles.PerformanceCar;
import vehicles.Pickup;

import java.util.ArrayList;
import java.util.List;

public class Activity {
    private static double budget;
    protected static List<Intern> interns;
    protected static List<Salesperson> salespersons;
    protected static List<Mechanic> mechanics;
    protected static List<Car> cars;
    protected static List<Pickup> pickups;
    protected static List<PerformanceCar> performanceCars;

    public Activity() {
        interns = new ArrayList<>();
        salespersons = new ArrayList<>();
        mechanics = new ArrayList<>();
        cars = new ArrayList<>();
        pickups = new ArrayList<>();
        performanceCars = new ArrayList<>();
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
}
