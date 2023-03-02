package activities;

import enums.Cleanliness;
import enums.WashingMethod;
import functions.Chemical;
import functions.Detailed;
import functions.ElbowGrease;
import functions.RandomNumberGenerator;
import abstracts.Staff;
import abstracts.Vehicle;
import printer.Printer;
import staff.Intern;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/*
This class is for the Washing activity.
Contains all the methods for washing.
 */
public class Washing extends Activity {
    private List<Vehicle> dirtyVehicles;
    private List<Vehicle> cleanVehicles;

    public Washing() {
        System.out.println("Washing..");
        System.out.println();
        dirtyVehicles = new ArrayList<>();
        cleanVehicles = new ArrayList<>();
        randomGenerator = new RandomNumberGenerator();
        printer = new Printer();
        segregateVehicles();
        shuffleVehicles();
        cleanCarsByInterns();
        System.out.println();
    }

    private void cleanCarsByInterns() {
        for(Staff intern : interns) {
            for(int i = 0; i<2; i++) {
                if(!dirtyVehicles.isEmpty()) {
                    assignVehicle(intern, dirtyVehicles);
                }
                else if(!cleanVehicles.isEmpty()) {
                    assignVehicle(intern, cleanVehicles);
                }
                else {
                    break;
                }
            }
            if(dirtyVehicles.isEmpty() && cleanVehicles.isEmpty()) break;
        }
    }

    private void assignVehicle(Staff intern, List<Vehicle> listOfVehiclesToBeCleaned) {
        int indexOfWashedVehicle = randomGenerator.generateRandomNumber(0,listOfVehiclesToBeCleaned.size()-1);
        Vehicle vehicle = listOfVehiclesToBeCleaned.get(indexOfWashedVehicle);
        cleanVehicles(intern, vehicle);
        setInternWorkedStatus(intern);
        if(vehicle.getCleanliness().equals(Cleanliness.SPARKLING)) {
            listOfVehiclesToBeCleaned.remove(indexOfWashedVehicle);
        }
    }

    private void setInternWorkedStatus(Staff intern) {
        intern.setWorked(true);
    }

    private void setInternBonus(Staff intern, Vehicle vehicle) {
        double washBonus = vehicle.getWashBonus();
        intern.setBonus(intern.getBonus() + washBonus);
    }

    private void cleanVehicles(Staff intern, Vehicle vehicle) {
        int randomNumber = randomGenerator.generateRandomNumber(1,100);
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
            setInternBonus(intern, vehicle);
            hasBonus = true;
        }
        if(vehicle.getCleanliness() != initialCleanliness) {
            hasCleaned = true;
        }

        printer.printWashedVehicles(intern, vehicle, hasCleaned, hasBonus, subscriberObject);
    }

    private void shuffleVehicles() {
        Collections.shuffle(dirtyVehicles);
        Collections.shuffle(cleanVehicles);
    }

    private void segregateVehicles() {
        segregateVehiclesOfType(cars);
        segregateVehiclesOfType(performanceCars);
        segregateVehiclesOfType(pickups);
        segregateVehiclesOfType(electricCars);
        segregateVehiclesOfType(monsterTrucks);
        segregateVehiclesOfType(motorcycles);
    }

    private void segregateVehiclesOfType(List<Vehicle> vehiclesToBeSegregated) {
        for(Vehicle vehicle : vehiclesToBeSegregated) {
            Cleanliness cleanlinessState = vehicle.getCleanliness();
            if (cleanlinessState == Cleanliness.DIRTY) dirtyVehicles.add(vehicle);
            else if (cleanlinessState == Cleanliness.CLEAN) cleanVehicles.add(vehicle);
        }
    }
}
