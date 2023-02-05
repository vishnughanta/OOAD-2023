package activities;

import staff.Intern;
import staff.Mechanic;
import staff.Salesperson;
import vehicles.Car;
import vehicles.PerformanceCar;
import vehicles.Pickup;

public class Opening extends Activity {
    
    public Opening() {
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
    }

    private void addPerformanceCars(int performanceCarsToBeAdded) {
        for(int i=0; i<performanceCarsToBeAdded; i++) {
            PerformanceCar performanceCar = new PerformanceCar();
            double performanceCarCostPrice = performanceCar.getCostPrice();
            if(getBudget() < performanceCarCostPrice) modifyOperatingBudget();
            performanceCars.add(performanceCar);
            setBudget(getBudget() - performanceCarCostPrice);
        }
    }

    private void checkPickups() {
        int currentPickupsSize = pickups.size();
        int pickupsToBeAdded = 4 - currentPickupsSize;
        addPickups(pickupsToBeAdded);
    }

    private void addPickups(int pickupsToBeAdded) {
        for(int i=0; i<pickupsToBeAdded; i++) {
            Pickup pickup = new Pickup();
            double pickupCostPrice = pickup.getCostPrice();
            if(getBudget() < pickupCostPrice) modifyOperatingBudget();
            pickups.add(pickup);
            setBudget(getBudget() - pickupCostPrice);
        }
    }

    private void checkCars() {
        int currentCarSize = cars.size();
        int carsToBeAdded = 4 - currentCarSize;
        addCars(carsToBeAdded);
    }

    private void addCars(int carsToBeAdded) {
        for(int i=0; i<carsToBeAdded; i++) {
            Car car = new Car();
            double carCostPrice = car.getCostPrice();
            if(getBudget() < carCostPrice) modifyOperatingBudget();
            cars.add(car);
            setBudget(getBudget() - carCostPrice);
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
    }

    private void addInterns(int internsToBeAdded) {
        for(int i=0; i<internsToBeAdded; i++) {
            Intern intern = new Intern();
            interns.add(intern);
        }
    }

    private void checkSalesPersons() {
        int currentSalesPersonSize = salespersons.size();
        int salesPersonsToBeAdded = 3 - currentSalesPersonSize;
        addSalesPersons(salesPersonsToBeAdded);
    }

    private void addSalesPersons(int salesPersonsToBeAdded) {
        for(int i=0; i<salesPersonsToBeAdded; i++) {
            Salesperson salesperson = new Salesperson();
            salespersons.add(salesperson);
        }
    }

    private void checkMechanics() {
        int currentMechanics = mechanics.size();
        int mechanicsToBeAdded = 3 - currentMechanics;
        addMechanics(mechanicsToBeAdded);
    }

    private void addMechanics(int mechanicsToBeAdded) {
        for(int i=0; i<mechanicsToBeAdded; i++) {
            Mechanic mechanic = new Mechanic();
            mechanics.add(mechanic);
        }
    }
}
