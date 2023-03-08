package main.java.activities;

import main.java.enums.Cleanliness;
import main.java.enums.WashingMethod;
import main.java.functions.Chemical;
import main.java.functions.Detailed;
import main.java.functions.ElbowGrease;
import main.java.functions.RandomNumberGenerator;
import main.java.abstracts.Staff;
import main.java.abstracts.Vehicle;
import main.java.interfaces.RandomGenerator;
import main.java.staff.Intern;
import main.java.printer.Printer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/*
This class is for the Washing activity.
Contains all the methods for washing.
 */
public class Washing {
    private main.java.interfaces.WashingMethod washingMethod;
    private RandomGenerator randomGenerator;
    private Printer printer;
    private List<Vehicle> dirtyVehicles, cleanVehicles;

    public Washing() {
    }

    public void startWashing(Activity activity) {
        System.out.println("Washing..");
        System.out.println();
        dirtyVehicles = new ArrayList<>();
        cleanVehicles = new ArrayList<>();
        randomGenerator = new RandomNumberGenerator();
        printer = new Printer();
        segregateVehicles(activity);
        shuffleVehicles();
        cleanCarsByInterns(activity);
        System.out.println();

    }

    private void cleanCarsByInterns(Activity activity) {
        List<Staff> interns = activity.getInterns();
        for(Staff intern : interns) {
            for(int i = 0; i<2; i++) {
                if(!dirtyVehicles.isEmpty()) {
                    assignVehicle(intern, dirtyVehicles, activity);
                }
                else if(!cleanVehicles.isEmpty()) {
                    assignVehicle(intern, cleanVehicles, activity);
                }
                else {
                    break;
                }
            }
            if(dirtyVehicles.isEmpty() && cleanVehicles.isEmpty()) break;
        }
    }

    private void assignVehicle(Staff intern, List<Vehicle> listOfVehiclesToBeCleaned, Activity activity) {
        int indexOfWashedVehicle = randomGenerator.generateRandomNumber(0,listOfVehiclesToBeCleaned.size()-1);
        Vehicle vehicle = listOfVehiclesToBeCleaned.get(indexOfWashedVehicle);
        cleanVehicles(intern, vehicle, activity);
        setInternWorkedStatus(intern);
        if(vehicle.getCleanliness().equals(Cleanliness.SPARKLING)) {
            listOfVehiclesToBeCleaned.remove(indexOfWashedVehicle);
        }
    }

    private void setInternWorkedStatus(Staff intern) {
        intern.setWorked(true);
    }

    private void setInternBonus(Staff intern, Vehicle vehicle, Activity activity) {
        double washBonus = vehicle.getWashBonus();
        activity.updateStaffAmount(activity.getSubscriberObject(), washBonus);
        intern.setBonus(intern.getBonus() + washBonus);
    }

    private void cleanVehicles(Staff intern, Vehicle vehicle, Activity activity) {
        Cleanliness initialCleanliness = vehicle.getCleanliness();
        boolean hasCleaned = false;
        boolean hasBonus = false;

        Intern internTypeCast = (Intern) intern;

        if(internTypeCast.getWashingMethod() == WashingMethod.CHEMICAL) {
            washingMethod = new Chemical();
            washingMethod.wash(vehicle);
        }
        else if(internTypeCast.getWashingMethod() == WashingMethod.DETAILED) {
            washingMethod = new Detailed();
            washingMethod.wash(vehicle);
        }
        else {
            washingMethod = new ElbowGrease();
            washingMethod.wash(vehicle);
        }

        if(vehicle.getCleanliness() == Cleanliness.SPARKLING) {
            setInternBonus(intern, vehicle, activity);
            hasBonus = true;
        }
        if(vehicle.getCleanliness() != initialCleanliness) {
            hasCleaned = true;
        }

        printer.printWashedVehicles(intern, vehicle, hasCleaned, hasBonus, activity.getSubscriberObject());
    }

    private void shuffleVehicles() {
        Collections.shuffle(dirtyVehicles);
        Collections.shuffle(cleanVehicles);
    }

    private void segregateVehicles(Activity activity) {
        segregateVehiclesOfType(activity.getCars());
        segregateVehiclesOfType(activity.getPickups());
        segregateVehiclesOfType(activity.getPerformanceCars());
        segregateVehiclesOfType(activity.getElectricCars());
        segregateVehiclesOfType(activity.getMotorcycles());
        segregateVehiclesOfType(activity.getMonsterTrucks());
    }

    private void segregateVehiclesOfType(List<Vehicle> vehiclesToBeSegregated) {
        for(Vehicle vehicle : vehiclesToBeSegregated) {
            Cleanliness cleanlinessState = vehicle.getCleanliness();
            if (cleanlinessState == Cleanliness.DIRTY) dirtyVehicles.add(vehicle);
            else if (cleanlinessState == Cleanliness.CLEAN) cleanVehicles.add(vehicle);
        }
    }
}
