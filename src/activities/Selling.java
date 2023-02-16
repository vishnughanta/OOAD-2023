package activities;

import abstracts.Staff;
import abstracts.Vehicle;
import buyer.Buyer;
import enums.BuyingType;
import enums.Cleanliness;
import enums.Condition;
import enums.VehicleType;
import functions.RandomNumberGenerator;
import printer.Printer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Selling extends Activity {
    private List<Vehicle> carsToBeSold;
    private List<Vehicle> performanceCarsToBeSold;
    private List<Vehicle> pickupsToBeSold;
    private int numberOfBuyers;
    public Selling(int day) {
        System.out.println("Selling..");
        System.out.println();
        printer = new Printer();
        carsToBeSold = new ArrayList<>();
        performanceCarsToBeSold = new ArrayList<>();
        pickupsToBeSold = new ArrayList<>();
        randomGenerator = new RandomNumberGenerator();
        segregateVehicles();
        sellVehicles(day);
        System.out.println();
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
            if(buyer.getVehicleType().equals(VehicleType.CAR)) sellCars(salesperson, buyer);
            else if(buyer.getVehicleType().equals(VehicleType.PICKUP)) sellPickups(salesperson, buyer);
            else sellPerformanceCars(salesperson, buyer);
            salesperson.setWorked(true);
        }
    }

    private void sellCars(Staff salesperson, Buyer buyer) {
        if(!carsToBeSold.isEmpty()) {
            sellVehicleOfType(salesperson, buyer, carsToBeSold);
        } else {
            sellVehiclesNotOfType(salesperson, buyer, performanceCarsToBeSold,pickupsToBeSold);
        }
    }

    private void sellPickups(Staff salesperson, Buyer buyer) {
        if(!pickupsToBeSold.isEmpty()) {
            sellVehicleOfType(salesperson, buyer, pickupsToBeSold);
        } else {
            sellVehiclesNotOfType(salesperson, buyer, carsToBeSold, performanceCarsToBeSold);
        }
    }

    private void sellPerformanceCars(Staff salesperson, Buyer buyer) {
        if(!performanceCarsToBeSold.isEmpty()) {
            sellVehicleOfType(salesperson, buyer, performanceCarsToBeSold);
        }
        else {
            sellVehiclesNotOfType(salesperson, buyer, carsToBeSold,pickupsToBeSold);
        }
    }

    private void sellVehicleOfType(Staff salesperson, Buyer buyer, List<Vehicle> list) {
        Vehicle vehicle = list.get(0);

        int chanceOfBuying = 0;
        if(buyer.getBuyingType() == BuyingType.JUST_LOOKING) chanceOfBuying = 10;
        else if(buyer.getBuyingType() == BuyingType.WANTS_ONE) chanceOfBuying = 40;
        else chanceOfBuying = 70;

        if(vehicle.getCleanliness().equals(Cleanliness.SPARKLING)) chanceOfBuying += 10;
        if(vehicle.getCondition().equals(Condition.NEW)) chanceOfBuying += 10;
        int randomNumber = randomGenerator.generateRandomNumber(1,100);
        if(randomNumber>=1 && randomNumber<=chanceOfBuying) {
            sellVehicle(salesperson, vehicle);
            printer.printSoldVehicles(salesperson, vehicle);
            setDailySales(getDailySales() + vehicle.getSalePrice());
            dailySoldVehicles.add(vehicle);
        }
    }

    private void sellVehiclesNotOfType(Staff salesperson, Buyer buyer, List<Vehicle> list1, List<Vehicle> list2) {
        List<Vehicle> otherCars = new ArrayList<>();
        otherCars.addAll(list1);
        otherCars.addAll(list2);
        sortCarsByCostPrice(otherCars);
        Vehicle vehicle = otherCars.get(0);

        int chanceOfBuying = 0;
        if(buyer.getBuyingType() == BuyingType.JUST_LOOKING) chanceOfBuying = 0;
        else if(buyer.getBuyingType() == BuyingType.WANTS_ONE) chanceOfBuying = 20;
        else chanceOfBuying = 50;

        if(vehicle.getCleanliness().equals(Cleanliness.SPARKLING)) chanceOfBuying += 10;
        if(vehicle.getCondition().equals(Condition.NEW)) chanceOfBuying += 10;
        int randomNumber = randomGenerator.generateRandomNumber(1,100);
        if(randomNumber>=1 && randomNumber<=chanceOfBuying) {
            sellVehicle(salesperson, vehicle);
            printer.printSoldVehicles(salesperson, vehicle);
            setDailySales(getDailySales() + vehicle.getSalePrice());
            dailySoldVehicles.add(vehicle);
        }
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
