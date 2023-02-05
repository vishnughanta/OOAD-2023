package activities;

import abstracts.Staff;
import abstracts.Vehicle;
import buyer.Buyer;
import enums.Cleanliness;
import enums.Condition;
import enums.VehicleType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Selling extends Activity {
    List<Vehicle> carsToBeSold;
    List<Vehicle> performanceCarsToBeSold;
    List<Vehicle> pickupsToBeSold;
    private int numberOfBuyers;
    public Selling() {
        carsToBeSold = new ArrayList<>();
        performanceCarsToBeSold = new ArrayList<>();
        pickupsToBeSold = new ArrayList<>();
        segregateVehicles();
    }

    private void segregateVehicles() {
        segregateCars();
        segregatePickups();
        segregatePerformanceCars();
    }

    public void sellVehicles(int day) {
        if(day % 7 >= 1 && day % 7 <=4) this.numberOfBuyers = randomGenerator.generateRandomNumber(0,5);
        else this.numberOfBuyers = randomGenerator.generateRandomNumber(2, 8);
        for(int i=0; i<numberOfBuyers; i++) {
            Buyer buyer = new Buyer();
            int indexOfSalesPerson = randomGenerator.generateRandomNumber(0,2);
            Staff salesperson = salespersons.get(indexOfSalesPerson);
            if(buyer.getVehicleType().equals(VehicleType.CAR)) sellCars(salesperson);
            else if(buyer.getVehicleType().equals(VehicleType.PICKUP)) sellPickups(salesperson);
            else sellPerformanceCars(salesperson);
            salesperson.setWorked(true);
        }
    }

    private void sellCars(Staff salesperson) {
        if(!carsToBeSold.isEmpty()) {
            sellVehicleOfType(salesperson, carsToBeSold);
        } else {
            sellVehiclesNotOfType(salesperson, performanceCarsToBeSold,pickupsToBeSold);
        }
    }

    private void sellPickups(Staff salesperson) {
        if(!pickupsToBeSold.isEmpty()) {
            sellVehicleOfType(salesperson, pickupsToBeSold);
        } else {
            sellVehiclesNotOfType(salesperson, carsToBeSold, performanceCarsToBeSold);
        }
    }

    private void sellPerformanceCars(Staff salesperson) {
        if(!performanceCarsToBeSold.isEmpty()) {
            sellVehicleOfType(salesperson, performanceCarsToBeSold);
        }
        else {
            sellVehiclesNotOfType(salesperson, carsToBeSold,pickupsToBeSold);
        }
    }

    private void sellVehicleOfType(Staff salesperson, List<Vehicle> list) {
        Vehicle vehicle = list.get(0);
        int chanceOfBuying = 50;
        if(vehicle.getCleanliness().equals(Cleanliness.SPARKLING)) chanceOfBuying += 10;
        if(vehicle.getCondition().equals(Condition.NEW)) chanceOfBuying += 10;
        int randomNumber = randomGenerator.generateRandomNumber(1,100);
        if(randomNumber>=1 && randomNumber<=chanceOfBuying) sellVehicle(salesperson, vehicle);
    }

    private void sellVehiclesNotOfType(Staff salesperson, List<Vehicle> list1, List<Vehicle> list2) {
        List<Vehicle> otherCars = new ArrayList<>();
        otherCars.addAll(list1);
        otherCars.addAll(list2);
        sortCarsByCostPrice(otherCars);
        Vehicle vehicle = otherCars.get(0);
        int chanceOfBuying = 30;
        if(vehicle.getCleanliness().equals(Cleanliness.SPARKLING)) chanceOfBuying += 10;
        if(vehicle.getCondition().equals(Condition.NEW)) chanceOfBuying += 10;
        int randomNumber = randomGenerator.generateRandomNumber(1,100);
        if(randomNumber>=1 && randomNumber<=chanceOfBuying) sellVehicle(salesperson, vehicle);
    }

    private void sellVehicle(Staff salesperson, Vehicle vehicle) {
        if(vehicle.getVehicleType().equals(VehicleType.CAR)) sellCar(salesperson, vehicle);
        else if(vehicle.getVehicleType().equals(VehicleType.PICKUP)) sellPickup(salesperson, vehicle);
        else sellPerformanceCar(salesperson, vehicle);
    }

    private void sellPerformanceCar(Staff staff, Vehicle vehicle) {
        performanceCarsToBeSold.remove(vehicle);
        performanceCars.remove(vehicle);
        soldVehicles.add(vehicle);
        setBudget(getBudget() + vehicle.getSalePrice());
        staff.setBonus(staff.getBonus() + vehicle.getSalesBonus());
    }

    private void sellPickup(Staff staff, Vehicle vehicle) {
        pickupsToBeSold.remove(vehicle);
        pickups.remove(vehicle);
        soldVehicles.add(vehicle);
        setBudget(getBudget() + vehicle.getSalePrice());
        staff.setBonus(staff.getBonus() + vehicle.getSalesBonus());
    }

    private void sellCar(Staff staff, Vehicle vehicle) {
        carsToBeSold.remove(vehicle);
        cars.remove(vehicle);
        soldVehicles.add(vehicle);
        setBudget(getBudget() + vehicle.getSalePrice());
        staff.setBonus(staff.getBonus() + vehicle.getSalesBonus());

    }

    private void segregatePerformanceCars() {
        for(Vehicle performanceCar : performanceCars) {
            if(!performanceCar.getCondition().equals(Condition.BROKEN)) performanceCarsToBeSold.add(performanceCar);
        }
        sortCarsByCostPrice(performanceCarsToBeSold);
    }

    private void segregatePickups() {
        for(Vehicle pickup : pickups) {
            if(!pickup.getCondition().equals(Condition.BROKEN)) pickupsToBeSold.add(pickup);
        }
        sortCarsByCostPrice(pickupsToBeSold);
    }

    private void segregateCars() {
        for(Vehicle car : cars) {
            if(!car.getCondition().equals(Condition.BROKEN)) carsToBeSold.add(car);
        }
        sortCarsByCostPrice(carsToBeSold);
    }

    private void sortCarsByCostPrice(List<Vehicle> list) {
        Collections.sort(list, (obj1, obj2) -> (int) (obj2.getCostPrice() - obj1.getCostPrice()));
    }
}
