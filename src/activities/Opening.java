package activities;

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
            Vehicle performanceCar = new PerformanceCar();
            double performanceCarCostPrice = performanceCar.getCostPrice();
            if(getBudget() < performanceCarCostPrice) modifyOperatingBudget();
            performanceCars.add(performanceCar);
            setBudget(getBudget() - performanceCarCostPrice);
            //System.out.println(performanceCar.getCleanliness());
            System.out.println("Purchased Performance Car " + performanceCar.getName() + " with a cost price of " + Double.toString(performanceCar.getCostPrice()));
        }
    }

    private void checkPickups() {
        int currentPickupsSize = pickups.size();
        int pickupsToBeAdded = 4 - currentPickupsSize;
        addPickups(pickupsToBeAdded);
    }

    private void addPickups(int pickupsToBeAdded) {
        for(int i=0; i<pickupsToBeAdded; i++) {
            Vehicle pickup = new Pickup();
            double pickupCostPrice = pickup.getCostPrice();
            if(getBudget() < pickupCostPrice) modifyOperatingBudget();
            pickups.add(pickup);
            setBudget(getBudget() - pickupCostPrice);
            System.out.println("Purchased Pickup " + pickup.getName() + " with a cost price of " + Double.toString(pickup.getCostPrice()));
        }
    }

    private void checkCars() {
        int currentCarSize = cars.size();
        int carsToBeAdded = 4 - currentCarSize;
        addCars(carsToBeAdded);
    }

    private void addCars(int carsToBeAdded) {
        for(int i=0; i<carsToBeAdded; i++) {
            Vehicle car = new Car();
            double carCostPrice = car.getCostPrice();
            if(getBudget() < carCostPrice) modifyOperatingBudget();
            cars.add(car);
            setBudget(getBudget() - carCostPrice);
            System.out.println("Purchased Car " + car.getName() + " with a cost price of " + Double.toString(car.getCostPrice()));
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
            Staff intern = new Intern();
            interns.add(intern);
            System.out.println("Hired Intern " + intern.getName() + " with a daily salary of " + Double.toString(intern.getSalary()));
        }

    }

    private void checkSalesPersons() {
        int currentSalesPersonSize = salespersons.size();
        int salesPersonsToBeAdded = 3 - currentSalesPersonSize;
        addSalesPersons(salesPersonsToBeAdded);

    }

    private void addSalesPersons(int salesPersonsToBeAdded) {
        for(int i=0; i<salesPersonsToBeAdded; i++) {
            Staff salesperson = new Salesperson();
            salespersons.add(salesperson);
            System.out.println("Hired Salesperson " + salesperson.getName() + " with a daily salary of " + Double.toString(salesperson.getSalary()));
        }
    }

    private void checkMechanics() {
        int currentMechanics = mechanics.size();
        int mechanicsToBeAdded = 3 - currentMechanics;
        addMechanics(mechanicsToBeAdded);

    }

    private void addMechanics(int mechanicsToBeAdded) {
        for(int i=0; i<mechanicsToBeAdded; i++) {
            Staff mechanic = new Mechanic();
            mechanics.add(mechanic);
            System.out.println("Hired Mechanic " + mechanic.getName() + " with a daily salary of " + Double.toString(mechanic.getSalary()));
        }
    }
}
