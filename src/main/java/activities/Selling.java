package main.java.activities;

import main.java.abstracts.Staff;
import main.java.abstracts.Vehicle;
import main.java.buyer.Buyer;
import main.java.decorator.ExtendedWarranty;
import main.java.decorator.RoadRescueCoverage;
import main.java.decorator.SatelliteRadio;
import main.java.decorator.Undercoating;
import main.java.enums.BuyingType;
import main.java.enums.Cleanliness;
import main.java.enums.Condition;
import main.java.enums.VehicleType;
import main.java.functions.RandomNumberGenerator;
import main.java.interfaces.RandomGenerator;
import main.java.printer.Printer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/*
This class is for the Selling activity.
Contains all the methods for selling.
 */
public class Selling {
    private List<Vehicle> listToBeSegregated, carsToBeSold, performanceCarsToBeSold, pickupsToBeSold, electricCarsToBeSold, motorcyclesToBeSold, monsterTrucksToBeSold, coupesToBeSold, suvsToBeSold, minivansToBeSold;
    private List<Vehicle> listToBeSoldOfType, listToBeSoldNotOfType;
    private int numberOfBuyers;
    private Printer printer;
    private RandomGenerator randomGenerator;
    private boolean isCommandLine;
    private Scanner scanner;
    public Selling(Activity activity) {
        System.out.println("Selling..");
        System.out.println();
        printer = new Printer();
        carsToBeSold = new ArrayList<>();
        performanceCarsToBeSold = new ArrayList<>();
        pickupsToBeSold = new ArrayList<>();
        electricCarsToBeSold = new ArrayList<>();
        motorcyclesToBeSold = new ArrayList<>();
        monsterTrucksToBeSold = new ArrayList<>();
        suvsToBeSold = new ArrayList<>();
        minivansToBeSold = new ArrayList<>();
        coupesToBeSold = new ArrayList<>();
        listToBeSoldOfType = new ArrayList<>();
        listToBeSoldNotOfType = new ArrayList<>();
        randomGenerator = new RandomNumberGenerator();
        isCommandLine = false;
        scanner = new Scanner(System.in);
        segregateVehicles(activity);
    }

    public void startSelling(Activity activity, int day) {
        sellVehicles(day, activity);
        System.out.println();
    }


    private void segregateVehicles(Activity activity) {
        segregateVehiclesByType(activity,activity.getCars());
        segregateVehiclesByType(activity, activity.getPickups());
        segregateVehiclesByType(activity, activity.getPerformanceCars());
        segregateVehiclesByType(activity, activity.getElectricCars());
        segregateVehiclesByType(activity, activity.getMotorcycles());
        segregateVehiclesByType(activity, activity.getMotorcycles());
        segregateVehiclesByType(activity, activity.getCoupes());
        segregateVehiclesByType(activity, activity.getMinivans());
        segregateVehiclesByType(activity, activity.getSuvs());
    }

    public void sellVehicles(int day, Activity activity) {
        if(day % 7 >= 1 && day % 7 <=4) this.numberOfBuyers = randomGenerator.generateRandomNumber(0,5);
        else this.numberOfBuyers = randomGenerator.generateRandomNumber(2, 8);
        for(int i=0; i<numberOfBuyers; i++) {
            Buyer buyer = new Buyer();
            int indexOfSalesPerson = randomGenerator.generateRandomNumber(0,2);
            List<Staff> salespersonsList = activity.getSalespersons();
            Staff salesperson = salespersonsList.get(indexOfSalesPerson);
            sellVehiclesByType(salesperson, buyer, activity);
            salesperson.setWorked(true);
        }
    }

    private void sellVehiclesByType(Staff staff, Buyer buyer, Activity activity) {
        if(buyer.getVehicleType() == VehicleType.CAR) {
            if(!carsToBeSold.isEmpty()) listToBeSoldOfType = carsToBeSold;
            else addVehiclesNotOfType(pickupsToBeSold, performanceCarsToBeSold, motorcyclesToBeSold, electricCarsToBeSold, monsterTrucksToBeSold, coupesToBeSold, minivansToBeSold, suvsToBeSold);
        }

        else if(buyer.getVehicleType() == VehicleType.PERFORMANCE_CAR) {
            if(!performanceCarsToBeSold.isEmpty()) listToBeSoldOfType = performanceCarsToBeSold;
            else addVehiclesNotOfType(pickupsToBeSold, carsToBeSold, motorcyclesToBeSold, electricCarsToBeSold, monsterTrucksToBeSold, coupesToBeSold, minivansToBeSold, suvsToBeSold);
        }

        else if(buyer.getVehicleType() == VehicleType.PICKUP) {
            if(!pickupsToBeSold.isEmpty()) listToBeSoldOfType = pickupsToBeSold;
            else addVehiclesNotOfType(performanceCarsToBeSold, carsToBeSold, motorcyclesToBeSold, electricCarsToBeSold, monsterTrucksToBeSold, coupesToBeSold, minivansToBeSold, suvsToBeSold);
        }

        else if(buyer.getVehicleType() == VehicleType.ELECTRIC_CAR) {
            if(!electricCarsToBeSold.isEmpty()) listToBeSoldOfType = electricCarsToBeSold;
            else addVehiclesNotOfType(performanceCarsToBeSold, carsToBeSold, motorcyclesToBeSold, pickupsToBeSold, monsterTrucksToBeSold, coupesToBeSold, minivansToBeSold, suvsToBeSold);
        }

        else if(buyer.getVehicleType() == VehicleType.MOTORCYCLE) {
            if(!motorcyclesToBeSold.isEmpty()) listToBeSoldOfType = motorcyclesToBeSold;
            else addVehiclesNotOfType(performanceCarsToBeSold, carsToBeSold, pickupsToBeSold, electricCarsToBeSold, monsterTrucksToBeSold, coupesToBeSold, minivansToBeSold, suvsToBeSold);
        }

        else if(buyer.getVehicleType() == VehicleType.MONSTER_TRUCK) {
            if(!monsterTrucksToBeSold.isEmpty()) listToBeSoldOfType = monsterTrucksToBeSold;
            else addVehiclesNotOfType(performanceCarsToBeSold, carsToBeSold, motorcyclesToBeSold, electricCarsToBeSold, pickupsToBeSold, coupesToBeSold, minivansToBeSold, suvsToBeSold);
        }
        else if(buyer.getVehicleType() == VehicleType.COUPE) {
            if(!coupesToBeSold.isEmpty()) listToBeSoldOfType = coupesToBeSold;
            else addVehiclesNotOfType(performanceCarsToBeSold, carsToBeSold, motorcyclesToBeSold, electricCarsToBeSold, pickupsToBeSold, monsterTrucksToBeSold, minivansToBeSold, suvsToBeSold);
        }
        else if(buyer.getVehicleType() == VehicleType.MINIVAN) {
            if(!minivansToBeSold.isEmpty()) listToBeSoldOfType = minivansToBeSold;
            else addVehiclesNotOfType(performanceCarsToBeSold, carsToBeSold, motorcyclesToBeSold, electricCarsToBeSold, pickupsToBeSold, coupesToBeSold, monsterTrucksToBeSold, suvsToBeSold);
        }
        else {
            if(!suvsToBeSold.isEmpty()) listToBeSoldOfType = suvsToBeSold;
            else addVehiclesNotOfType(performanceCarsToBeSold, carsToBeSold, motorcyclesToBeSold, electricCarsToBeSold, pickupsToBeSold, coupesToBeSold, minivansToBeSold, monsterTrucksToBeSold);
        }

        if(!listToBeSoldOfType.isEmpty()) sellVehicleOfType(staff, buyer,listToBeSoldOfType, activity);
        else sellVehiclesNotOfType(staff, buyer, listToBeSoldNotOfType, activity);
    }

    private void addVehiclesNotOfType(List<Vehicle> list1, List<Vehicle> list2, List<Vehicle> list3, List<Vehicle> list4, List<Vehicle> list5, List<Vehicle> list6, List<Vehicle> list7, List<Vehicle> list8) {
        listToBeSoldNotOfType.addAll(list1);
        listToBeSoldNotOfType.addAll(list2);
        listToBeSoldNotOfType.addAll(list3);
        listToBeSoldNotOfType.addAll(list4);
        listToBeSoldNotOfType.addAll(list5);
        listToBeSoldNotOfType.addAll(list6);
        listToBeSoldNotOfType.addAll(list7);
        listToBeSoldNotOfType.addAll(list8);
    }

    private void sellVehicleOfType(Staff salesperson, Buyer buyer, List<Vehicle> list, Activity activity) {
        List<Vehicle> vehiclesOfType = new ArrayList<>(list);
        sortCarsByCostPrice(vehiclesOfType);
        Vehicle vehicle = vehiclesOfType.get(0);
        int chance = randomGenerator.generateRandomNumber(1,100);
        int chanceOfBuying = chanceOfBuyingCalculator(buyer, vehicle, 10, 40, 70);
        if(chance>=1 && chance<=chanceOfBuying) {
            sellVehicleHelper(salesperson, vehicle, activity);
        }
    }

    private void sellVehiclesNotOfType(Staff salesperson, Buyer buyer, List<Vehicle> list, Activity activity) {
        List<Vehicle> otherVehicles = new ArrayList<>(list);
        sortCarsByCostPrice(otherVehicles);
        Vehicle vehicle = otherVehicles.get(0);
        int chance = randomGenerator.generateRandomNumber(1,100);
        int chanceOfBuying = chanceOfBuyingCalculator(buyer, vehicle, 0, 20, 50);
        if(chance>=1 && chance<=chanceOfBuying) {
            sellVehicleHelper(salesperson, vehicle, activity);
        }
    }

    private int chanceOfBuyingCalculator(Buyer buyer, Vehicle vehicle, int justLookingChanceOfBuying, int wantsOneChanceOfBuying, int needsOneChanceOfBuying) {
        int chanceOfBuying = 0;
        if(buyer.getBuyingType() == BuyingType.JUST_LOOKING) chanceOfBuying = justLookingChanceOfBuying;
        else if(buyer.getBuyingType() == BuyingType.WANTS_ONE) chanceOfBuying = wantsOneChanceOfBuying;
        else chanceOfBuying = needsOneChanceOfBuying;

        if(vehicle.getCleanliness().equals(Cleanliness.SPARKLING)) chanceOfBuying += 10;
        if(vehicle.getCondition().equals(Condition.NEW)) chanceOfBuying += 10;
        return chanceOfBuying;
    }

    public void sellVehicleHelper(Staff salesperson, Vehicle vehicle, Activity activity) {
        sellVehicle(activity, salesperson, vehicle);
        sellAddOns(vehicle);
        printer.printSoldVehicles(salesperson, vehicle, activity.getSubscriberObject());
        double finalSalePrice = vehicle.getFinalSalePrice();
        activity.updateFNCDAmount(activity.getSubscriberObject(), finalSalePrice);
        activity.setDailySales(activity.getDailySales() + vehicle.getFinalSalePrice());
        activity.setBudget(activity.getBudget() + finalSalePrice);
        List<Vehicle> dailySoldVehicles = activity.getDailySoldVehicles();
        dailySoldVehicles.add(vehicle);
        activity.setDailySoldVehicles(dailySoldVehicles);
    }

    private void sellAddOns(Vehicle vehicle) {
        String userInput = "n";
        Vehicle tempVehicle = vehicle;
        if(isCommandLine) {
            System.out.println("Do you want to add Extended Warranty? (Y/N)");
            userInput = scanner.next();
        }
        int extendedWarrantyChance = randomGenerator.generateRandomNumber(1,100);
        if(extendedWarrantyChance >0 && extendedWarrantyChance <=25 || userInput.toLowerCase().equals("y")) {
            tempVehicle = new ExtendedWarranty(vehicle);
        }

        if(isCommandLine) {
            System.out.println("Do you want to add Road Rescue Coverage? (Y/N)");
            userInput = scanner.next();
        }
        int roadRescueCoverageChance = randomGenerator.generateRandomNumber(1,100);
        if(roadRescueCoverageChance >0 && roadRescueCoverageChance <=5 || userInput.toLowerCase().equals("y")) {
            tempVehicle = new RoadRescueCoverage(vehicle);
        }

        if(isCommandLine) {
            System.out.println("Do you want to add Satellite Radio? (Y/N)");
            userInput = scanner.next();
        }
        int satelliteRadioChance = randomGenerator.generateRandomNumber(1,100);
        if(satelliteRadioChance >0 && satelliteRadioChance <=5 || userInput.toLowerCase().equals("y")) {
            tempVehicle = new SatelliteRadio(vehicle);
        }

        if(isCommandLine) {
            System.out.println("Do you want to add Undercoating? (Y/N)");
            userInput = scanner.next();
        }
        int undercoatingChance = randomGenerator.generateRandomNumber(1,100);
        if(undercoatingChance >0 && undercoatingChance <=5 || userInput.toLowerCase().equals("y")) {
            tempVehicle = new Undercoating(vehicle);
        }
        vehicle.setFinalSalePrice(tempVehicle.getFinalPriceAfterAddOns());
    }

    private void sellVehicle(Activity activity, Staff salesperson, Vehicle vehicle) {
        if(vehicle.getVehicleType().equals(VehicleType.CAR)) sellAndRemoveVehicleOfType(activity, salesperson, vehicle, carsToBeSold, activity.getCars());
        else if(vehicle.getVehicleType().equals(VehicleType.PICKUP)) sellAndRemoveVehicleOfType(activity, salesperson, vehicle, pickupsToBeSold, activity.getPickups());
        else if(vehicle.getVehicleType() == VehicleType.PERFORMANCE_CAR) sellAndRemoveVehicleOfType(activity, salesperson, vehicle, performanceCarsToBeSold, activity.getPerformanceCars());
        else if(vehicle.getVehicleType() == VehicleType.ELECTRIC_CAR) sellAndRemoveVehicleOfType(activity, salesperson, vehicle, electricCarsToBeSold, activity.getElectricCars());
        else if(vehicle.getVehicleType() == VehicleType.MOTORCYCLE) sellAndRemoveVehicleOfType(activity, salesperson, vehicle, motorcyclesToBeSold, activity.getMotorcycles());
        else if(vehicle.getVehicleType() == VehicleType.MONSTER_TRUCK) sellAndRemoveVehicleOfType(activity, salesperson, vehicle, monsterTrucksToBeSold, activity.getMonsterTrucks());
        else if(vehicle.getVehicleType() == VehicleType.COUPE) sellAndRemoveVehicleOfType(activity, salesperson, vehicle, coupesToBeSold, activity.getCoupes());
        else if(vehicle.getVehicleType() == VehicleType.MINIVAN) sellAndRemoveVehicleOfType(activity, salesperson, vehicle, minivansToBeSold, activity.getMinivans());
        else sellAndRemoveVehicleOfType(activity, salesperson, vehicle, suvsToBeSold, activity.getSuvs());
    }

    private void sellAndRemoveVehicleOfType(Activity activity, Staff staff, Vehicle vehicle, List<Vehicle> listOfVehicleTypeSold, List<Vehicle> listOfVehicle) {
        listOfVehicleTypeSold.remove(vehicle);
        removeVehicle(activity, vehicle, listOfVehicle);
        List<Vehicle> soldVehicles = activity.getSoldVehicles();
        soldVehicles.add(vehicle);
        activity.setSoldVehicles(soldVehicles);
        double saleBonus = vehicle.getSalesBonus();
        activity.updateStaffAmount(activity.getSubscriberObject(), saleBonus);
        staff.setBonus(staff.getBonus() + saleBonus);
    }

    private void removeVehicle(Activity activity, Vehicle vehicle, List<Vehicle> listOfVehicle) {
        if(listOfVehicle.equals(activity.getCars())) {
            List<Vehicle> vehicles = activity.getCars();
            vehicles.remove(vehicle);
            activity.setCars(vehicles);
        }
        else if(listOfVehicle.equals(activity.getPerformanceCars())) {
            List<Vehicle> vehicles = activity.getPerformanceCars();
            vehicles.remove(vehicle);
            activity.setPerformanceCars(vehicles);
        }
        else if(listOfVehicle.equals(activity.getPickups())) {
            List<Vehicle> vehicles = activity.getPickups();
            vehicles.remove(vehicle);
            activity.setPickups(vehicles);
        }
        else if(listOfVehicle.equals(activity.getMotorcycles())) {
            List<Vehicle> vehicles = activity.getMotorcycles();
            vehicles.remove(vehicle);
            activity.setMotorcycles(vehicles);
        }
        else if(listOfVehicle.equals(activity.getElectricCars())) {
            List<Vehicle> vehicles = activity.getElectricCars();
            vehicles.remove(vehicle);
            activity.setElectricCars(vehicles);
        }
        else if(listOfVehicle.equals(activity.getMonsterTrucks())) {
            List<Vehicle> vehicles = activity.getMonsterTrucks();
            vehicles.remove(vehicle);
            activity.setMonsterTrucks(vehicles);
        }
        else if(listOfVehicle.equals(activity.getCoupes())) {
            List<Vehicle> vehicles = activity.getCoupes();
            vehicles.remove(vehicle);
            activity.setCoupes(vehicles);
        }
        else if(listOfVehicle.equals(activity.getMinivans())) {
            List<Vehicle> vehicles = activity.getMinivans();
            vehicles.remove(vehicle);
            activity.setMinivans(vehicles);
        }
        else if(listOfVehicle.equals(activity.getSuvs())) {
            List<Vehicle> vehicles = activity.getSuvs();
            vehicles.remove(vehicle);
            activity.setSuvs(vehicles);
        }
    }

    private void segregateVehiclesByType(Activity activity, List<Vehicle> vehiclesToBeSegregated) {
        if(vehiclesToBeSegregated.equals(activity.getCars())) {
            listToBeSegregated = carsToBeSold;
        }
        else if(vehiclesToBeSegregated.equals(activity.getPickups())) {
            listToBeSegregated = pickupsToBeSold;
        }
        else if(vehiclesToBeSegregated.equals(activity.getPerformanceCars())) {
            listToBeSegregated = performanceCarsToBeSold;
        }
        else if(vehiclesToBeSegregated.equals(activity.getElectricCars())) {
            listToBeSegregated = electricCarsToBeSold;
        }
        else if(vehiclesToBeSegregated.equals(activity.getMotorcycles())) {
            listToBeSegregated = motorcyclesToBeSold;
        }
        else if(vehiclesToBeSegregated.equals(activity.getMonsterTrucks())){
            listToBeSegregated = monsterTrucksToBeSold;
        }
        else if(vehiclesToBeSegregated.equals(activity.getCoupes())) {
            listToBeSegregated = coupesToBeSold;
        }
        else if(vehiclesToBeSegregated.equals(activity.getSuvs())) {
            listToBeSegregated = suvsToBeSold;
        }
        else if(vehiclesToBeSegregated.equals(activity.getMinivans())) {
            listToBeSegregated = minivansToBeSold;
        }

        for(Vehicle vehicle : vehiclesToBeSegregated) {
            if(vehicle.getCondition() != Condition.BROKEN) {
                listToBeSegregated.add(vehicle);
            }
        }
        sortCarsByCostPrice(listToBeSegregated);
    }
    private void sortCarsByCostPrice(List<Vehicle> list) {
        Collections.sort(list, (obj1, obj2) -> (int) (obj2.getCostPrice() - obj1.getCostPrice()));
    }

    public boolean isCommandLine() {
        return isCommandLine;
    }

    public void setCommandLine(boolean commandLine) {
        isCommandLine = commandLine;
    }
}
