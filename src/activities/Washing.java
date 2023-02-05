package activities;

import enums.Cleanliness;
import functions.RandomNumberGenerator;
import abstracts.Staff;
import abstracts.Vehicle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Washing extends Activity {
    private List<Vehicle> dirtyVehicles;
    private List<Vehicle> cleanVehicles;

    public Washing() {
        dirtyVehicles = new ArrayList<>();
        cleanVehicles = new ArrayList<>();
        randomGenerator = new RandomNumberGenerator();
        segregateVehicles();
        shuffleCars();
        cleanCarsInterns();
    }

    private void cleanCarsInterns() {
        List<Vehicle> carsToBeCleaned = new ArrayList<>();
        carsToBeCleaned.addAll(dirtyVehicles);
        carsToBeCleaned.addAll(cleanVehicles);

        for(Staff intern : interns) {
            for(int i = 0; i<2; i++) {
                if(carsToBeCleaned.isEmpty()) break;
                Vehicle vehicle = carsToBeCleaned.get(0);
                cleanVehicles(vehicle);
                setInternWorkedStatus(intern);
                if(vehicle.getCleanliness().equals(Cleanliness.SPARKLING)) setInternBonus(intern, vehicle);
                carsToBeCleaned.remove(0);
            }
            if(carsToBeCleaned.isEmpty()) break;
        }
    }

    private void setInternWorkedStatus(Staff intern) {
        intern.setWorked(true);
    }

    private void setInternBonus(Staff intern, Vehicle vehicle) {
        double washBonus = vehicle.getWashBonus();
        intern.setBonus(intern.getBonus() + washBonus);
    }

    private void cleanVehicles(Vehicle vehicle) {
        if(vehicle.getCleanliness().equals(Cleanliness.DIRTY)) {
            int randomNumber = randomGenerator.generateRandomNumber(1,100);
            if(randomNumber >= 1 && randomNumber <= 80 ) vehicle.setCleanliness(Cleanliness.CLEAN);
            else if(randomNumber > 80 && randomNumber <=90) vehicle.setCleanliness(Cleanliness.SPARKLING);
        } else {
            int randomNumber = randomGenerator.generateRandomNumber(1,100);
            if(randomNumber >= 1 && randomNumber <= 5 ) vehicle.setCleanliness(Cleanliness.DIRTY);
            else if(randomNumber > 5 && randomNumber <=40) vehicle.setCleanliness(Cleanliness.SPARKLING);
        }
    }

    private void shuffleCars() {
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
            if (cleanlinessState.equals(Cleanliness.DIRTY)) dirtyVehicles.add(vehicle);
            else if (cleanlinessState.equals(Cleanliness.CLEAN)) cleanVehicles.add(vehicle);
        }
    }

    private void segregatePickups() {
        for (Vehicle vehicle : pickups) {
            Cleanliness cleanlinessState = vehicle.getCleanliness();
            if (cleanlinessState.equals(Cleanliness.DIRTY)) dirtyVehicles.add(vehicle);
            else if (cleanlinessState.equals(Cleanliness.CLEAN)) cleanVehicles.add(vehicle);
        }
    }

    private void segregateCars() {
        for (Vehicle vehicle : cars) {
            Cleanliness cleanlinessState = vehicle.getCleanliness();
            if (cleanlinessState.equals(Cleanliness.DIRTY)) dirtyVehicles.add(vehicle);
            else if (cleanlinessState.equals(Cleanliness.CLEAN)) cleanVehicles.add(vehicle);
        }
    }


}
