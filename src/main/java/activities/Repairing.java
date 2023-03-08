package main.java.activities;

import main.java.abstracts.Staff;
import main.java.abstracts.Vehicle;
import main.java.enums.Cleanliness;
import main.java.enums.Condition;
import main.java.functions.RandomNumberGenerator;
import main.java.interfaces.RandomGenerator;
import main.java.printer.Printer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/*
This class is for the Repairing activity.
Contains all the methods for repairing.
 */
public class Repairing {
    private List<Vehicle> vehiclesToBeRepaired;
    private RandomGenerator randomGenerator;
    private Printer printer;
    public Repairing() {

    }

    public void startRepairing(Activity activity) {
        System.out.println("Repairing..");
        System.out.println();
        vehiclesToBeRepaired = new ArrayList<>();
        randomGenerator = new RandomNumberGenerator();
        printer = new Printer();
        segregateVehicles(activity);
        shuffleVehicles();
        repairVehiclesMechanics(activity);
        System.out.println();
    }

    private void repairVehiclesMechanics(Activity activity) {
        List<Staff> mechanics = activity.getMechanics();
        for(Staff mechanic : mechanics) {
            for(int i=0; i<2; i++) {
                if(vehiclesToBeRepaired.isEmpty()) break;
                int indexOfVehicleToBeRepaired = randomGenerator.generateRandomNumber(0, vehiclesToBeRepaired.size()-1);
                Vehicle vehicle = vehiclesToBeRepaired.get(indexOfVehicleToBeRepaired);
                repairVehicles(mechanic, vehicle, activity);
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

    private void repairVehicles(Staff mechanic, Vehicle vehicle, Activity activity) {
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
            double repairBonus = vehicle.getRepairBonus();
            activity.updateStaffAmount(activity.getSubscriberObject(), repairBonus);
            mechanic.setBonus(mechanic.getBonus() + repairBonus);
        }
        printer.printRepairedVehicles(mechanic, vehicle, hasRepaired, activity.getSubscriberObject());
    }

    private void shuffleVehicles() {
        Collections.shuffle(vehiclesToBeRepaired);
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
            Condition condition = vehicle.getCondition();
            if (condition.equals(Condition.BROKEN) || condition.equals(Condition.USED)) vehiclesToBeRepaired.add(vehicle);
        }
    }
}
