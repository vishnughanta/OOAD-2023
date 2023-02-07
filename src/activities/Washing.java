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
        shuffleVehicles();
        cleanCarsByInterns();
    }

    private void cleanCarsByInterns() {
        List<Vehicle> vehiclesToBeCleaned = new ArrayList<>();
        vehiclesToBeCleaned.addAll(dirtyVehicles);
        vehiclesToBeCleaned.addAll(cleanVehicles);

        for(Staff intern : interns) {
            for(int i = 0; i<2; i++) {
                if(vehiclesToBeCleaned.isEmpty()) break;
                Vehicle vehicle = vehiclesToBeCleaned.get(0);
                cleanVehicles(intern, vehicle);
                setInternWorkedStatus(intern);
                if(vehicle.getCleanliness().equals(Cleanliness.SPARKLING)) setInternBonus(intern, vehicle);
                vehiclesToBeCleaned.remove(0);
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
        if(vehicle.getCleanliness().equals(Cleanliness.DIRTY)) {
            if(randomNumber >= 1 && randomNumber <= 80 ) {
                vehicle.setCleanliness(Cleanliness.CLEAN);
                System.out.println("Intern " + intern.getName() + " washed " + vehicle.getVehicleType() + " " + vehicle.getName() + " and made it clean");
            }
            else if(randomNumber > 80 && randomNumber <=90) {
                vehicle.setCleanliness(Cleanliness.SPARKLING);
                System.out.println("Intern " + intern.getName() + " washed " + vehicle.getVehicleType() + " " + vehicle.getName() + " and made it sparkling(Earned " + Double.toString(vehicle.getWashBonus()) + " Wash Bonus)");
            }
        } else {
            if(randomNumber >= 1 && randomNumber <= 5 ) {
                vehicle.setCleanliness(Cleanliness.DIRTY);
                System.out.println("Intern " + intern.getName() + " washed " + vehicle.getVehicleType() + " " + vehicle.getName()  + " and made it dirty");
            }
            else if(randomNumber > 5 && randomNumber <=40) {
                vehicle.setCleanliness(Cleanliness.SPARKLING);
                System.out.println("Intern " + intern.getName() + " washed " + vehicle.getVehicleType() + " " + vehicle.getName() + " and made it sparkling(Earned " + Double.toString(vehicle.getWashBonus()) + " Wash Bonus)");
            }
        }
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
