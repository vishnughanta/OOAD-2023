package main.java.activities;

import main.java.printer.Printer;
import main.java.staff.Driver;
import main.java.staff.Intern;
import main.java.staff.Mechanic;
import main.java.staff.Salesperson;
import main.java.abstracts.Staff;
import main.java.vehicles.*;
import main.java.abstracts.Vehicle;

import java.util.List;

/*
This class is for the Opening activity.
Contains all the methods for opening the day.
 */
public class Opening {
    private Printer printer;
    private Vehicle vehicleToBeAdded;
    private int countOfVehicles = 6;
    private int countOfStaff = 3;
    public Opening() {
        printer = new Printer();
    }

    public void startOpening(Activity activity) {
        System.out.println("Opening..");
        System.out.println("Current budget: " + activity.getBudget());
        System.out.println();
        printer = new Printer();
        checkVehicles(activity);

    }

    private void checkVehicles(Activity activity) {
        checkAndAddVehicles(activity, activity.getCars());
    }

    private void checkAndAddVehicles(Activity activity, List<Vehicle> listOfVehiclesToBeCheckedAndAdded) {
        if(!listOfVehiclesToBeCheckedAndAdded.isEmpty() && listOfVehiclesToBeCheckedAndAdded.size() != countOfStaff) {
            addVehicles(activity, listOfVehiclesToBeCheckedAndAdded);
        }
    }

    private void addVehicles(Activity activity, List<Vehicle> listOfVehiclesToBeCheckedAndAdded) {
        int currVehicleSize = listOfVehiclesToBeCheckedAndAdded.size();
        int vehiclesToBeAdded = countOfVehicles - currVehicleSize;

        for(int i=0; i<vehiclesToBeAdded; i++) {
            if(listOfVehiclesToBeCheckedAndAdded.equals(activity.getCars())) {
                vehicleToBeAdded = new Car();
            }
            else if(listOfVehiclesToBeCheckedAndAdded.equals(activity.getPickups())) {
                vehicleToBeAdded = new Pickup();
            }
            else if(listOfVehiclesToBeCheckedAndAdded.equals(activity.getPerformanceCars())) {
                vehicleToBeAdded = new PerformanceCar();
            }
            else if(listOfVehiclesToBeCheckedAndAdded.equals(activity.getElectricCars())) {
                vehicleToBeAdded = new ElectricCar();
            }
            else if(listOfVehiclesToBeCheckedAndAdded.equals(activity.getMotorcycles())) {
                vehicleToBeAdded = new ElectricCar();
            }
            else if(listOfVehiclesToBeCheckedAndAdded.equals(activity.getMonsterTrucks())) {
                vehicleToBeAdded = new MonsterTruck();
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


//    private void checkElectricCars(Activity activity) {
//        int currentElectricCarsSize = activity.getElectricCars().size();
//        int electricCarsToBeAdded = 4 - currentElectricCarsSize;
//        addElectricCars(electricCarsToBeAdded, activity);
//        if(electricCarsToBeAdded!=0) System.out.println();
//    }
//
//    private void addElectricCars(int electricCarsToBeAdded, Activity activity) {
//        for(int i=0; i<electricCarsToBeAdded; i++) {
//            Vehicle electricCar = new ElectricCar();
//            double electricCarCostPrice = electricCar.getCostPrice();
//            if(activity.getBudget() < electricCarCostPrice) {
//                modifyOperatingBudget(activity);
//            }
//            List<Vehicle> currentElectricCarsList = activity.getElectricCars();
//            currentElectricCarsList.add(electricCar);
//            activity.setElectricCars(currentElectricCarsList);
//
//            activity.setBudget(getBudget() - electricCarCostPrice);
//            printer.printPurchasedVehiclesInOpening(electricCar, subscriberObject);
//            Vehicle.electricCarNumber++;
//        }
//    }
//
//    private void checkMonsterTrucks(Activity activity) {
//        int currentMonsterTruckSize = monsterTrucks.size();
//        int monsterTrucksToBeAdded = 4 - currentMonsterTruckSize;
//        addMonsterTrucks(monsterTrucksToBeAdded);
//        if(monsterTrucksToBeAdded!=0) System.out.println();
//    }
//
//    private void addMonsterTrucks(int monsterTrucksToBeAdded) {
//        for(int i=0; i<monsterTrucksToBeAdded; i++) {
//            Vehicle monsterTruck = new MonsterTruck();
//            double monsterTruckCostPrice = monsterTruck.getCostPrice();
//            if(getBudget() < monsterTruckCostPrice) {
//                modifyOperatingBudget();
//            }
//            monsterTrucks.add(monsterTruck);
//            setBudget(getBudget() - monsterTruckCostPrice);
//            printer.printPurchasedVehiclesInOpening(monsterTruck, subscriberObject);
//            Vehicle.monsterTruckNumber++;
//        }
//    }
//
//    private void checkMotorcycles(Activity activity) {
//        int currentMotorcyleSize = motorcycles.size();
//        int motorcyclesToBeAdded = 4 - currentMotorcyleSize;
//        addMotorcycles(motorcyclesToBeAdded);
//        if(motorcyclesToBeAdded!=0) System.out.println();
//    }
//
//    private void addMotorcycles(int motorcyclesToBeAdded) {
//        for(int i=0; i<motorcyclesToBeAdded; i++) {
//            Vehicle motorcycle = new Motorcycle();
//            double motorcycleCostPrice = motorcycle.getCostPrice();
//            if(getBudget() < motorcycleCostPrice) {
//                modifyOperatingBudget();
//            }
//            motorcycles.add(motorcycle);
//            setBudget(getBudget() - motorcycleCostPrice);
//            printer.printPurchasedVehiclesInOpening(motorcycle, subscriberObject);
//            Vehicle.motorcycleNumber++;
//        }
//    }
//
//    private void checkPerformanceCars(Activity activity) {
//        int currentPerformanceCarsSize = performanceCars.size();
//        int performanceCarsToBeAdded = 4 - currentPerformanceCarsSize;
//        addPerformanceCars(performanceCarsToBeAdded);
//        if(performanceCarsToBeAdded!=0) System.out.println();
//    }
//
//    private void addPerformanceCars(int performanceCarsToBeAdded) {
//        for(int i=0; i<performanceCarsToBeAdded; i++) {
//            Vehicle performanceCar = new PerformanceCar();
//            double performanceCarCostPrice = performanceCar.getCostPrice();
//            if(getBudget() < performanceCarCostPrice) {
//                modifyOperatingBudget();
//            }
//            performanceCars.add(performanceCar);
//            setBudget(getBudget() - performanceCarCostPrice);
//            printer.printPurchasedVehiclesInOpening(performanceCar, subscriberObject);
//            Vehicle.performanceCarNumber++;
//        }
//    }
//
//    private void checkPickups(Activity activity) {
//        int currentPickupsSize = pickups.size();
//        int pickupsToBeAdded = 4 - currentPickupsSize;
//        addPickups(pickupsToBeAdded);
//        if(pickupsToBeAdded!=0) System.out.println();
//    }
//
//    private void addPickups(int pickupsToBeAdded) {
//        for(int i=0; i<pickupsToBeAdded; i++) {
//            Vehicle pickup = new Pickup();
//            double pickupCostPrice = pickup.getCostPrice();
//            if(getBudget() < pickupCostPrice) {
//                modifyOperatingBudget();
//            }
//            pickups.add(pickup);
//            setBudget(getBudget() - pickupCostPrice);
//            printer.printPurchasedVehiclesInOpening(pickup, subscriberObject);
//            Vehicle.pickupNumber++;
//        }
//    }
//
//    private void checkCars(Activity activity) {
//        int currentCarSize = cars.size();
//        int carsToBeAdded = 4 - currentCarSize;
//        addCars(carsToBeAdded);
//        if(carsToBeAdded!=0) System.out.println();
//    }
//
//    private void addCars(int carsToBeAdded) {
//        for(int i=0; i<carsToBeAdded; i++) {
//            Vehicle car = new Car();
//            double carCostPrice = car.getCostPrice();
//            if(getBudget() < carCostPrice) modifyOperatingBudget();
//            cars.add(car);
//            setBudget(getBudget() - carCostPrice);
//            printer.printPurchasedVehiclesInOpening(car, subscriberObject);
//            Vehicle.carNumber++;
//        }
//    }
//
//    private void checkStaff(Activity activity) {
//        checkMechanics();
//        checkSalesPersons();
//        checkInterns();
//        checkDrivers();
//    }
//
//    private void checkDrivers() {
//        int currentDriverSize = drivers.size();
//        int driversToBeAdded = 3 - currentDriverSize;
//        addDrivers(driversToBeAdded);
//        if(driversToBeAdded!=0) System.out.println();
//    }
//
//    private void addDrivers(int driversToBeAdded) {
//        for(int i=0; i<driversToBeAdded; i++) {
//            Staff driver = new Driver();
//            drivers.add(driver);
//            printer.printHiredStaffInOpening(driver, subscriberObject);
//            Staff.driverNumber++;
//        }
//    }
//
//    private void checkInterns() {
//        int currentInternSize = interns.size();
//        int internsToBeAdded = 3 - currentInternSize;
//        addInterns(internsToBeAdded);
//        if(internsToBeAdded!=0) System.out.println();
//    }
//
//    private void addInterns(int internsToBeAdded) {
//        for(int i=0; i<internsToBeAdded; i++) {
//            Staff intern = new Intern();
//            interns.add(intern);
//            printer.printHiredStaffInOpening(intern, subscriberObject);
//            Staff.internNumber++;
//        }
//    }
//
//    private void checkSalesPersons() {
//        int currentSalesPersonSize = salespersons.size();
//        int salesPersonsToBeAdded = 3 - currentSalesPersonSize;
//        addSalesPersons(salesPersonsToBeAdded);
//        if(salesPersonsToBeAdded!=0) System.out.println();
//    }
//
//    private void addSalesPersons(int salesPersonsToBeAdded) {
//        for(int i=0; i<salesPersonsToBeAdded; i++) {
//            Staff salesperson = new Salesperson();
//            salespersons.add(salesperson);
//            printer.printHiredStaffInOpening(salesperson, subscriberObject);
//            Staff.salespersonNumber++;
//        }
//    }
//
//    private void checkMechanics() {
//        int currentMechanics = mechanics.size();
//        int mechanicsToBeAdded = 3 - currentMechanics;
//        addMechanics(mechanicsToBeAdded);
//        if(mechanicsToBeAdded!=0) System.out.println();
//    }
//
//    private void addMechanics(int mechanicsToBeAdded) {
//        for(int i=0; i<mechanicsToBeAdded; i++) {
//            Staff mechanic = new Mechanic();
//            mechanics.add(mechanic);
//            printer.printHiredStaffInOpening(mechanic, subscriberObject);
//            Staff.mechanicNumber++;
//        }
//    }
}
