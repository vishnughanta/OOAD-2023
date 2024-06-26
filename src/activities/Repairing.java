package activities;

import abstracts.Staff;
import abstracts.Vehicle;
import enums.Cleanliness;
import enums.Condition;
import functions.RandomNumberGenerator;
import printer.Printer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/*
This class is for the Repairing activity.
Contains all the methods for repairing.
 */
public class Repairing extends Activity {
    private List<Vehicle> vehiclesToBeRepaired;
    public Repairing() {
        System.out.println("Repairing..");
        System.out.println();
        vehiclesToBeRepaired = new ArrayList<>();
        randomGenerator = new RandomNumberGenerator();
        printer = new Printer();
        segregateVehicles();
        shuffleVehicles();
        repairVehiclesMechanics();
        System.out.println();
    }

    private void repairVehiclesMechanics() {
        for(Staff mechanic : mechanics) {
            for(int i=0; i<2; i++) {
                if(vehiclesToBeRepaired.isEmpty()) break;
                int indexOfVehicleToBeRepaired = randomGenerator.generateRandomNumber(0, vehiclesToBeRepaired.size()-1);
                Vehicle vehicle = vehiclesToBeRepaired.get(indexOfVehicleToBeRepaired);
                repairVehicles(mechanic, vehicle);
                updateCleanlinessState(vehicle);
                mechanic.setWorked(true);
                if(vehicle.getCondition() == Condition.NEW) {
                    vehiclesToBeRepaired.remove(indexOfVehicleToBeRepaired);
                }
            }
            if(vehiclesToBeRepaired.isEmpty()) break;
        }
    }

    private void updateCleanlinessState(Vehicle vehicle) {
        if(vehicle.getCleanliness().equals(Cleanliness.SPARKLING)) {
            vehicle.setCleanliness(Cleanliness.CLEAN);
        }
        else {
            vehicle.setCleanliness(Cleanliness.DIRTY);
        }
    }

    private void repairVehicles(Staff mechanic, Vehicle vehicle) {
        int randomNumber = randomGenerator.generateRandomNumber(1,100);
        boolean hasRepaired = false;
        if(randomNumber > 0 && randomNumber <= 80) {
            hasRepaired = true;
            if(vehicle.getCondition().equals(Condition.BROKEN)) {
                vehicle.setCondition(Condition.USED);
                vehicle.setSalePrice(1.5 * vehicle.getSalePrice());
            }
            else {
                vehicle.setCondition(Condition.NEW);
                vehicle.setSalePrice(1.25 * vehicle.getSalePrice());
            }
            mechanic.setBonus(mechanic.getBonus() + vehicle.getRepairBonus());
        }
        printer.printRepairedVehicles(mechanic, vehicle, hasRepaired);
    }

    private void shuffleVehicles() {
        Collections.shuffle(vehiclesToBeRepaired);
    }

    private void segregateVehicles() {
        segregateCars();
        segregatePickups();
        segregatePerformanceCars();
    }

    private void segregatePerformanceCars() {
        for (Vehicle vehicle : performanceCars) {
            Condition condition = vehicle.getCondition();
            if (condition.equals(Condition.BROKEN) || condition.equals(Condition.USED)) vehiclesToBeRepaired.add(vehicle);
        }
    }

    private void segregatePickups() {
        for (Vehicle vehicle : pickups) {
            Condition condition = vehicle.getCondition();
            if (condition.equals(Condition.BROKEN) || condition.equals(Condition.USED)) vehiclesToBeRepaired.add(vehicle);
        }
    }

    private void segregateCars() {
        for (Vehicle vehicle : cars) {
            Condition condition = vehicle.getCondition();
            if (condition.equals(Condition.BROKEN) || condition.equals(Condition.USED)) vehiclesToBeRepaired.add(vehicle);
        }
    }

}
