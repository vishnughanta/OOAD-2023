package main.java.activities;

import main.java.factories.StaffFactory;
import main.java.factories.VehicleFactory;
import main.java.interfaces.FNCDFactory;
import main.java.printer.Printer;
import main.java.abstracts.Staff;
import main.java.abstracts.Vehicle;

import java.util.List;

/*
This class is for the Opening activity.
Contains all the methods for opening the day.
 */
public class Opening {
    private Printer printer;
    private Vehicle vehicleToBeAdded;
    private Staff staffToBeAdded;
    private final int countOfVehicles = 6;
    private final int countOfStaff = 3;
    public Opening() {
        printer = new Printer();
    }

    public void startOpening(Activity activity) {
        System.out.println("Opening..");
        System.out.println("Current budget: " + activity.getBudget());
        System.out.println();
        printer = new Printer();
        checkStaff(activity);
        checkVehicles(activity);
    }

    private void checkStaff(Activity activity) {
        checkAndAddStaff(activity, activity.getInterns());
        checkAndAddStaff(activity, activity.getMechanics());
        checkAndAddStaff(activity, activity.getSalespersons());
        checkAndAddStaff(activity, activity.getDrivers());
    }

    private void checkAndAddStaff(Activity activity, List<Staff> listOfStaffToBeCheckedAndAdded) {
        if(listOfStaffToBeCheckedAndAdded.size() != countOfStaff) {
            addStaff(activity, listOfStaffToBeCheckedAndAdded);
        }
    }

    private void addStaff(Activity activity, List<Staff> listOfStaffToBeCheckedAndAdded) {
        int currStaffSize = listOfStaffToBeCheckedAndAdded.size();
        int staffNumberToBeAdded = countOfStaff - currStaffSize;

        for(int i=0; i<staffNumberToBeAdded; i++) {
            if(listOfStaffToBeCheckedAndAdded.equals(activity.getInterns())) {
                FNCDFactory<Staff> staffFNCDFactory = new StaffFactory();
                staffToBeAdded = staffFNCDFactory.create(1);
            }
            else if(listOfStaffToBeCheckedAndAdded.equals(activity.getMechanics())) {
                FNCDFactory<Staff> staffFNCDFactory = new StaffFactory();
                staffToBeAdded = staffFNCDFactory.create(2);
            }
            else if(listOfStaffToBeCheckedAndAdded.equals(activity.getSalespersons())) {
                FNCDFactory<Staff> staffFNCDFactory = new StaffFactory();
                staffToBeAdded = staffFNCDFactory.create(3);
            }
            else if(listOfStaffToBeCheckedAndAdded.equals(activity.getDrivers())){
                FNCDFactory<Staff> staffFNCDFactory = new StaffFactory();
                staffToBeAdded = staffFNCDFactory.create(4);
            }

            listOfStaffToBeCheckedAndAdded.add(staffToBeAdded);
            printer.printHiredStaffInOpening(staffToBeAdded, activity.getSubscriberObject());
        }
    }

    private void checkVehicles(Activity activity) {
        checkAndAddVehicles(activity, activity.getCars());
        checkAndAddVehicles(activity, activity.getPickups());
        checkAndAddVehicles(activity, activity.getPerformanceCars());
        checkAndAddVehicles(activity, activity.getElectricCars());
        checkAndAddVehicles(activity, activity.getMotorcycles());
        checkAndAddVehicles(activity, activity.getMonsterTrucks());
    }

    private void checkAndAddVehicles(Activity activity, List<Vehicle> listOfVehiclesToBeCheckedAndAdded) {
        if(listOfVehiclesToBeCheckedAndAdded.size() != countOfStaff) {
            addVehicles(activity, listOfVehiclesToBeCheckedAndAdded);
        }
    }

    private void addVehicles(Activity activity, List<Vehicle> listOfVehiclesToBeCheckedAndAdded) {
        int currVehicleSize = listOfVehiclesToBeCheckedAndAdded.size();
        int vehiclesToBeAdded = countOfVehicles - currVehicleSize;

        for(int i=0; i<vehiclesToBeAdded; i++) {
            FNCDFactory<Vehicle> vehicleFNCDFactory = new VehicleFactory();
            if(listOfVehiclesToBeCheckedAndAdded.equals(activity.getCars())) {
                vehicleToBeAdded = vehicleFNCDFactory.create(1);
            }
            else if(listOfVehiclesToBeCheckedAndAdded.equals(activity.getPickups())) {
                vehicleToBeAdded = vehicleFNCDFactory.create(2);
            }
            else if(listOfVehiclesToBeCheckedAndAdded.equals(activity.getPerformanceCars())) {
                vehicleToBeAdded = vehicleFNCDFactory.create(3);
            }
            else if(listOfVehiclesToBeCheckedAndAdded.equals(activity.getElectricCars())) {
                vehicleToBeAdded = vehicleFNCDFactory.create(4);
            }
            else if(listOfVehiclesToBeCheckedAndAdded.equals(activity.getMotorcycles())) {
                vehicleToBeAdded = vehicleFNCDFactory.create(5);
            }
            else if(listOfVehiclesToBeCheckedAndAdded.equals(activity.getMonsterTrucks())) {
                vehicleToBeAdded = vehicleFNCDFactory.create(6);
            }

            double vehicleCostPrice = vehicleToBeAdded.getCostPrice();
            while(activity.getBudget() < vehicleCostPrice) {
                activity.modifyOperatingBudget(activity);
            }
            listOfVehiclesToBeCheckedAndAdded.add(vehicleToBeAdded);
            activity.setBudget(activity.getBudget() - vehicleCostPrice);
            printer.printPurchasedVehiclesInOpening(vehicleToBeAdded, activity.getSubscriberObject());

        }
    }
}
