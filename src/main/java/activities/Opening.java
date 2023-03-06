package main.java.activities;

import main.java.printer.Printer;
import main.java.staff.Driver;
import main.java.staff.Intern;
import main.java.staff.Mechanic;
import main.java.staff.Salesperson;
import main.java.abstracts.Staff;
import main.java.vehicles.*;
import main.java.abstracts.Vehicle;
/*
This class is for the Opening activity.
Contains all the methods for opening the day.
 */
public class Opening extends Activity {
    
    public Opening() {
        System.out.println("Opening..");
        System.out.println("Current budget: " + getBudget());
        System.out.println();
        printer = new Printer();
        checkStaff();
        checkVehicles();
    }

    private void checkVehicles() {
        checkCars();
        checkPickups();
        checkPerformanceCars();
        checkMotorcycles();
        checkMonsterTrucks();
        checkElectricCars();
    }

    private void checkElectricCars() {
        int currentElectricCarsSize = electricCars.size();
        int electricCarsToBeAdded = 4 - currentElectricCarsSize;
        addElectricCars(electricCarsToBeAdded);
        if(electricCarsToBeAdded!=0) System.out.println();
    }

    private void addElectricCars(int electricCarsToBeAdded) {
        for(int i=0; i<electricCarsToBeAdded; i++) {
            Vehicle electricCar = new ElectricCar();
            double electricCarCostPrice = electricCar.getCostPrice();
            if(getBudget() < electricCarCostPrice) {
                modifyOperatingBudget();
            }
            electricCars.add(electricCar);
            setBudget(getBudget() - electricCarCostPrice);
            printer.printPurchasedVehiclesInOpening(electricCar, subscriberObject);
            Vehicle.electricCarNumber++;
        }
    }

    private void checkMonsterTrucks() {
        int currentMonsterTruckSize = monsterTrucks.size();
        int monsterTrucksToBeAdded = 4 - currentMonsterTruckSize;
        addMonsterTrucks(monsterTrucksToBeAdded);
        if(monsterTrucksToBeAdded!=0) System.out.println();
    }

    private void addMonsterTrucks(int monsterTrucksToBeAdded) {
        for(int i=0; i<monsterTrucksToBeAdded; i++) {
            Vehicle monsterTruck = new MonsterTruck();
            double monsterTruckCostPrice = monsterTruck.getCostPrice();
            if(getBudget() < monsterTruckCostPrice) {
                modifyOperatingBudget();
            }
            monsterTrucks.add(monsterTruck);
            setBudget(getBudget() - monsterTruckCostPrice);
            printer.printPurchasedVehiclesInOpening(monsterTruck, subscriberObject);
            Vehicle.monsterTruckNumber++;
        }
    }

    private void checkMotorcycles() {
        int currentMotorcyleSize = motorcycles.size();
        int motorcyclesToBeAdded = 4 - currentMotorcyleSize;
        addMotorcycles(motorcyclesToBeAdded);
        if(motorcyclesToBeAdded!=0) System.out.println();
    }

    private void addMotorcycles(int motorcyclesToBeAdded) {
        for(int i=0; i<motorcyclesToBeAdded; i++) {
            Vehicle motorcycle = new Motorcycle();
            double motorcycleCostPrice = motorcycle.getCostPrice();
            if(getBudget() < motorcycleCostPrice) {
                modifyOperatingBudget();
            }
            motorcycles.add(motorcycle);
            setBudget(getBudget() - motorcycleCostPrice);
            printer.printPurchasedVehiclesInOpening(motorcycle, subscriberObject);
            Vehicle.motorcycleNumber++;
        }
    }

    private void checkPerformanceCars() {
        int currentPerformanceCarsSize = performanceCars.size();
        int performanceCarsToBeAdded = 4 - currentPerformanceCarsSize;
        addPerformanceCars(performanceCarsToBeAdded);
        if(performanceCarsToBeAdded!=0) System.out.println();
    }

    private void addPerformanceCars(int performanceCarsToBeAdded) {
        for(int i=0; i<performanceCarsToBeAdded; i++) {
            Vehicle performanceCar = new PerformanceCar();
            double performanceCarCostPrice = performanceCar.getCostPrice();
            if(getBudget() < performanceCarCostPrice) {
                modifyOperatingBudget();
            }
            performanceCars.add(performanceCar);
            setBudget(getBudget() - performanceCarCostPrice);
            printer.printPurchasedVehiclesInOpening(performanceCar, subscriberObject);
            Vehicle.performanceCarNumber++;
        }
    }

    private void checkPickups() {
        int currentPickupsSize = pickups.size();
        int pickupsToBeAdded = 4 - currentPickupsSize;
        addPickups(pickupsToBeAdded);
        if(pickupsToBeAdded!=0) System.out.println();
    }

    private void addPickups(int pickupsToBeAdded) {
        for(int i=0; i<pickupsToBeAdded; i++) {
            Vehicle pickup = new Pickup();
            double pickupCostPrice = pickup.getCostPrice();
            if(getBudget() < pickupCostPrice) {
                modifyOperatingBudget();
            }
            pickups.add(pickup);
            setBudget(getBudget() - pickupCostPrice);
            printer.printPurchasedVehiclesInOpening(pickup, subscriberObject);
            Vehicle.pickupNumber++;
        }
    }

    private void checkCars() {
        int currentCarSize = cars.size();
        int carsToBeAdded = 4 - currentCarSize;
        addCars(carsToBeAdded);
        if(carsToBeAdded!=0) System.out.println();
    }

    private void addCars(int carsToBeAdded) {
        for(int i=0; i<carsToBeAdded; i++) {
            Vehicle car = new Car();
            double carCostPrice = car.getCostPrice();
            if(getBudget() < carCostPrice) modifyOperatingBudget();
            cars.add(car);
            setBudget(getBudget() - carCostPrice);
            printer.printPurchasedVehiclesInOpening(car, subscriberObject);
            Vehicle.carNumber++;
        }
    }

    private void checkStaff() {
        checkMechanics();
        checkSalesPersons();
        checkInterns();
        checkDrivers();
    }

    private void checkDrivers() {
        int currentDriverSize = drivers.size();
        int driversToBeAdded = 3 - currentDriverSize;
        addDrivers(driversToBeAdded);
        if(driversToBeAdded!=0) System.out.println();
    }

    private void addDrivers(int driversToBeAdded) {
        for(int i=0; i<driversToBeAdded; i++) {
            Staff driver = new Driver();
            drivers.add(driver);
            printer.printHiredStaffInOpening(driver, subscriberObject);
            Staff.driverNumber++;
        }
    }

    private void checkInterns() {
        int currentInternSize = interns.size();
        int internsToBeAdded = 3 - currentInternSize;
        addInterns(internsToBeAdded);
        if(internsToBeAdded!=0) System.out.println();
    }

    private void addInterns(int internsToBeAdded) {
        for(int i=0; i<internsToBeAdded; i++) {
            Staff intern = new Intern();
            interns.add(intern);
            printer.printHiredStaffInOpening(intern, subscriberObject);
            Staff.internNumber++;
        }
    }

    private void checkSalesPersons() {
        int currentSalesPersonSize = salespersons.size();
        int salesPersonsToBeAdded = 3 - currentSalesPersonSize;
        addSalesPersons(salesPersonsToBeAdded);
        if(salesPersonsToBeAdded!=0) System.out.println();
    }

    private void addSalesPersons(int salesPersonsToBeAdded) {
        for(int i=0; i<salesPersonsToBeAdded; i++) {
            Staff salesperson = new Salesperson();
            salespersons.add(salesperson);
            printer.printHiredStaffInOpening(salesperson, subscriberObject);
            Staff.salespersonNumber++;
        }
    }

    private void checkMechanics() {
        int currentMechanics = mechanics.size();
        int mechanicsToBeAdded = 3 - currentMechanics;
        addMechanics(mechanicsToBeAdded);
        if(mechanicsToBeAdded!=0) System.out.println();
    }

    private void addMechanics(int mechanicsToBeAdded) {
        for(int i=0; i<mechanicsToBeAdded; i++) {
            Staff mechanic = new Mechanic();
            mechanics.add(mechanic);
            printer.printHiredStaffInOpening(mechanic, subscriberObject);
            Staff.mechanicNumber++;
        }
    }
}
