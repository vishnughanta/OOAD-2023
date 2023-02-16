package activities;

import enums.Cleanliness;
import functions.RandomNumberGenerator;
import abstracts.Staff;
import abstracts.Vehicle;
import printer.Printer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
        List<Vehicle> vehiclesToBeCleaned = new ArrayList<>();
        vehiclesToBeCleaned.addAll(dirtyVehicles);
        vehiclesToBeCleaned.addAll(cleanVehicles);

        for(Staff intern : interns) {
            for(int i = 0; i<2; i++) {
                if(vehiclesToBeCleaned.isEmpty()) break;
                int indexOfWashedVehicle = randomGenerator.generateRandomNumber(0,vehiclesToBeCleaned.size()-1);
                Vehicle vehicle = vehiclesToBeCleaned.get(indexOfWashedVehicle);
                cleanVehicles(intern, vehicle);
                setInternWorkedStatus(intern);
                if(vehicle.getCleanliness().equals(Cleanliness.SPARKLING)) {
                    setInternBonus(intern, vehicle);
                    vehiclesToBeCleaned.remove(indexOfWashedVehicle);
                }
            }
            if(vehiclesToBeCleaned.isEmpty()) break;
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
        boolean hasCleaned = false;
        boolean hasBonus = false;
        if(vehicle.getCleanliness().equals(Cleanliness.DIRTY)) {
            if(randomNumber >= 1 && randomNumber <= 80 ) {
                vehicle.setCleanliness(Cleanliness.CLEAN);
                hasCleaned = true;
            }
            else if(randomNumber > 80 && randomNumber <=90) {
                vehicle.setCleanliness(Cleanliness.SPARKLING);
                hasCleaned = true;
                hasBonus = true;
            }
        } else {
            if(randomNumber >= 1 && randomNumber <= 5 ) {
                vehicle.setCleanliness(Cleanliness.DIRTY);
                hasCleaned = true;
            }
            else if(randomNumber > 5 && randomNumber <=40) {
                vehicle.setCleanliness(Cleanliness.SPARKLING);
                hasCleaned = true;
                hasBonus = true;
            }
        }
        printer.printWashedVehicles(intern, vehicle, hasCleaned, hasBonus);
    }

    private void shuffleVehicles() {
        Collections.shuffle(dirtyVehicles);
        Collections.shuffle(cleanVehicles);
    }

    private void segregateVehicles() {
        segregateCars();
        segregatePickups();
        segregatePerformanceCars();
    }

    private void segregatePerformanceCars() {
        for (Vehicle vehicle : performanceCars) {
            Cleanliness cleanlinessState = vehicle.getCleanliness();
            if (cleanlinessState == Cleanliness.DIRTY) dirtyVehicles.add(vehicle);
            else if (cleanlinessState == Cleanliness.CLEAN) cleanVehicles.add(vehicle);
        }
    }

    private void segregatePickups() {
        for (Vehicle vehicle : pickups) {
            Cleanliness cleanlinessState = vehicle.getCleanliness();
            if (cleanlinessState == Cleanliness.DIRTY) dirtyVehicles.add(vehicle);
            else if (cleanlinessState == Cleanliness.CLEAN) cleanVehicles.add(vehicle);
        }
    }

    private void segregateCars() {
        for (Vehicle vehicle : cars) {
            Cleanliness cleanlinessState = vehicle.getCleanliness();
            if (cleanlinessState == Cleanliness.DIRTY) dirtyVehicles.add(vehicle);
            else if (cleanlinessState == Cleanliness.CLEAN) cleanVehicles.add(vehicle);
        }
    }


}
