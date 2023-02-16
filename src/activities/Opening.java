package activities;

import printer.Printer;
import staff.Intern;
import staff.Mechanic;
import staff.Salesperson;
import abstracts.Staff;
import vehicles.Car;
import vehicles.PerformanceCar;
import vehicles.Pickup;
import abstracts.Vehicle;

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
            printer.printPurchasedVehiclesInOpening(performanceCar);
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
            printer.printPurchasedVehiclesInOpening(pickup);
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
            printer.printPurchasedVehiclesInOpening(car);
            Vehicle.carNumber++;
        }
    }

    private void checkStaff() {
        checkMechanics();
        checkSalesPersons();
        checkInterns();
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
            printer.printHiredStaffInOpening(intern);
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
            printer.printHiredStaffInOpening(salesperson);
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
            printer.printHiredStaffInOpening(mechanic);
            Staff.mechanicNumber++;
        }
    }
}
