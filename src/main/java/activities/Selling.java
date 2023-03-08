//package main.java.activities;
//
//import main.java.abstracts.Staff;
//import main.java.abstracts.Vehicle;
//import main.java.buyer.Buyer;
//import main.java.decorator.ExtendedWarranty;
//import main.java.decorator.RoadRescueCoverage;
//import main.java.decorator.SatelliteRadio;
//import main.java.decorator.Undercoating;
//import main.java.enums.BuyingType;
//import main.java.enums.Cleanliness;
//import main.java.enums.Condition;
//import main.java.enums.VehicleType;
//import main.java.functions.RandomNumberGenerator;
//import main.java.printer.Printer;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
///*
//This class is for the Selling activity.
//Contains all the methods for selling.
// */
//public class Selling extends Activity {
//    private List<Vehicle> listToBeSegregated, carsToBeSold, performanceCarsToBeSold, pickupsToBeSold, electricCarsToBeSold, motorcyclesToBeSold, monsterTrucksToBeSold;
//    private List<Vehicle> listToBeSoldOfType, listToBeSoldNotOfType;
//    private int numberOfBuyers;
//    public Selling(int day) {
//        System.out.println("Selling..");
//        System.out.println();
//        printer = new Printer();
//        carsToBeSold = new ArrayList<>();
//        performanceCarsToBeSold = new ArrayList<>();
//        pickupsToBeSold = new ArrayList<>();
//        electricCarsToBeSold = new ArrayList<>();
//        motorcyclesToBeSold = new ArrayList<>();
//        monsterTrucksToBeSold = new ArrayList<>();
//        listToBeSoldOfType = new ArrayList<>();
//        listToBeSoldNotOfType = new ArrayList<>();
//        randomGenerator = new RandomNumberGenerator();
//        segregateVehicles();
//        sellVehicles(day);
//        System.out.println();
//    }
//
//
//    private void segregateVehicles() {
//        segregateVehiclesByType(cars);
//        segregateVehiclesByType(pickups);
//        segregateVehiclesByType(performanceCars);
//        segregateVehiclesByType(electricCars);
//        segregateVehiclesByType(motorcycles);
//        segregateVehiclesByType(monsterTrucks);
//    }
//
//    public void sellVehicles(int day) {
//        if(day % 7 >= 1 && day % 7 <=4) this.numberOfBuyers = randomGenerator.generateRandomNumber(0,5);
//        else this.numberOfBuyers = randomGenerator.generateRandomNumber(2, 8);
//        for(int i=0; i<numberOfBuyers; i++) {
//            Buyer buyer = new Buyer();
//            int indexOfSalesPerson = randomGenerator.generateRandomNumber(0,2);
//            Staff salesperson = salespersons.get(indexOfSalesPerson);
//            sellVehiclesByType(salesperson, buyer);
//            salesperson.setWorked(true);
//        }
//    }
//
//    private void sellVehiclesByType(Staff staff, Buyer buyer) {
//        if(buyer.getVehicleType() == VehicleType.CAR) {
//            if(!carsToBeSold.isEmpty()) listToBeSoldOfType = carsToBeSold;
//            else addVehiclesNotOfType(pickupsToBeSold, performanceCarsToBeSold, motorcyclesToBeSold, electricCarsToBeSold, monsterTrucksToBeSold);
//        }
//
//        else if(buyer.getVehicleType() == VehicleType.PERFORMANCE_CAR) {
//            if(!performanceCarsToBeSold.isEmpty()) listToBeSoldOfType = performanceCarsToBeSold;
//            else addVehiclesNotOfType(pickupsToBeSold, carsToBeSold, motorcyclesToBeSold, electricCarsToBeSold, monsterTrucksToBeSold);
//        }
//
//        else if(buyer.getVehicleType() == VehicleType.PICKUP) {
//            if(!pickupsToBeSold.isEmpty()) listToBeSoldOfType = pickupsToBeSold;
//            else addVehiclesNotOfType(performanceCarsToBeSold, carsToBeSold, motorcyclesToBeSold, electricCarsToBeSold, monsterTrucksToBeSold);
//        }
//
//        else if(buyer.getVehicleType() == VehicleType.ELECTRIC_CAR) {
//            if(!electricCarsToBeSold.isEmpty()) listToBeSoldOfType = electricCarsToBeSold;
//            else addVehiclesNotOfType(performanceCarsToBeSold, carsToBeSold, motorcyclesToBeSold, pickupsToBeSold, monsterTrucksToBeSold);
//        }
//
//        else if(buyer.getVehicleType() == VehicleType.MOTORCYCLE) {
//            if(!motorcyclesToBeSold.isEmpty()) listToBeSoldOfType = motorcyclesToBeSold;
//            else addVehiclesNotOfType(performanceCarsToBeSold, carsToBeSold, pickupsToBeSold, electricCarsToBeSold, monsterTrucksToBeSold);
//        }
//
//        else if(buyer.getVehicleType() == VehicleType.MONSTER_TRUCK) {
//            if(!monsterTrucksToBeSold.isEmpty()) listToBeSoldOfType = monsterTrucksToBeSold;
//            else addVehiclesNotOfType(performanceCarsToBeSold, carsToBeSold, motorcyclesToBeSold, electricCarsToBeSold, pickupsToBeSold);
//        }
//
//        if(!listToBeSoldOfType.isEmpty()) sellVehicleOfType(staff, buyer,listToBeSoldOfType);
//        else sellVehiclesNotOfType(staff, buyer, listToBeSoldNotOfType);
//    }
//
//    private void addVehiclesNotOfType(List<Vehicle> list1, List<Vehicle> list2, List<Vehicle> list3, List<Vehicle> list4, List<Vehicle> list5) {
//        listToBeSoldNotOfType.addAll(list1);
//        listToBeSoldNotOfType.addAll(list2);
//        listToBeSoldNotOfType.addAll(list3);
//        listToBeSoldNotOfType.addAll(list4);
//        listToBeSoldNotOfType.addAll(list5);
//    }
//
//    private void sellVehicleOfType(Staff salesperson, Buyer buyer, List<Vehicle> list) {
//        Vehicle vehicle = list.get(0);
//
//        int chanceOfBuying = 0;
//        if(buyer.getBuyingType() == BuyingType.JUST_LOOKING) chanceOfBuying = 10;
//        else if(buyer.getBuyingType() == BuyingType.WANTS_ONE) chanceOfBuying = 40;
//        else chanceOfBuying = 70;
//
//        if(vehicle.getCleanliness().equals(Cleanliness.SPARKLING)) chanceOfBuying += 10;
//        if(vehicle.getCondition().equals(Condition.NEW)) chanceOfBuying += 10;
//        int randomNumber = randomGenerator.generateRandomNumber(1,100);
//        if(randomNumber>=1 && randomNumber<=chanceOfBuying) {
//            sellVehicle(salesperson, vehicle);
//            sellAddOns(vehicle);
//            printer.printSoldVehicles(salesperson, vehicle, subscriberObject);
//            double finalSalePrice = vehicle.getFinalSalePrice();
//            updateFNCDAmount(subscriberObject, finalSalePrice);
//            setDailySales(getDailySales() + vehicle.getFinalSalePrice());
//            dailySoldVehicles.add(vehicle);
//        }
//    }
//
//    private void sellVehiclesNotOfType(Staff salesperson, Buyer buyer, List<Vehicle> list) {
//        List<Vehicle> otherCars = new ArrayList<>(list);
//        sortCarsByCostPrice(otherCars);
//        Vehicle vehicle = otherCars.get(0);
//
//        int chanceOfBuying = 0;
//        if(buyer.getBuyingType() == BuyingType.JUST_LOOKING) chanceOfBuying = 0;
//        else if(buyer.getBuyingType() == BuyingType.WANTS_ONE) chanceOfBuying = 20;
//        else chanceOfBuying = 50;
//
//        if(vehicle.getCleanliness().equals(Cleanliness.SPARKLING)) chanceOfBuying += 10;
//        if(vehicle.getCondition().equals(Condition.NEW)) chanceOfBuying += 10;
//        int randomNumber = randomGenerator.generateRandomNumber(1,100);
//        if(randomNumber>=1 && randomNumber<=chanceOfBuying) {
//            sellVehicle(salesperson, vehicle);
//            sellAddOns(vehicle);
//            setBudget(getBudget() + vehicle.getFinalSalePrice());
//            printer.printSoldVehicles(salesperson, vehicle, subscriberObject);
//            setDailySales(getDailySales() + vehicle.getSalePrice());
//            dailySoldVehicles.add(vehicle);
//        }
//    }
//
//    private void sellAddOns(Vehicle vehicle) {
//        Vehicle tempVehicle = vehicle;
//
//        int extendedWarrantyChance = randomGenerator.generateRandomNumber(1,100);
//        if(extendedWarrantyChance >0 && extendedWarrantyChance <=25) {
//            tempVehicle = new ExtendedWarranty(vehicle);
//        }
//
//        int roadRescueCoverageChance = randomGenerator.generateRandomNumber(1,100);
//        if(roadRescueCoverageChance >0 && roadRescueCoverageChance <=5) {
//            tempVehicle = new RoadRescueCoverage(vehicle);
//        }
//
//        int satelliteRadioChance = randomGenerator.generateRandomNumber(1,100);
//        if(satelliteRadioChance >0 && satelliteRadioChance <=5) {
//            tempVehicle = new SatelliteRadio(vehicle);
//        }
//
//        int undercoatingChance = randomGenerator.generateRandomNumber(1,100);
//        if(undercoatingChance >0 && undercoatingChance <=5) {
//            tempVehicle = new Undercoating(vehicle);
//        }
//
//        vehicle.setFinalSalePrice(tempVehicle.getFinalPriceAfterAddOns());
//
//
//    }
//
//    private void sellVehicle(Staff salesperson, Vehicle vehicle) {
//        if(vehicle.getVehicleType().equals(VehicleType.CAR)) sellAndRemoveVehicleOfType(salesperson, vehicle, carsToBeSold, cars);
//        else if(vehicle.getVehicleType().equals(VehicleType.PICKUP)) sellAndRemoveVehicleOfType(salesperson, vehicle, pickupsToBeSold, pickups);
//        else if(vehicle.getVehicleType() == VehicleType.PERFORMANCE_CAR) sellAndRemoveVehicleOfType(salesperson, vehicle, performanceCarsToBeSold, performanceCars);
//        else if(vehicle.getVehicleType() == VehicleType.ELECTRIC_CAR) sellAndRemoveVehicleOfType(salesperson, vehicle, electricCarsToBeSold, electricCars);
//        else if(vehicle.getVehicleType() == VehicleType.MOTORCYCLE) sellAndRemoveVehicleOfType(salesperson, vehicle, motorcyclesToBeSold, motorcycles);
//        else sellAndRemoveVehicleOfType(salesperson, vehicle, monsterTrucksToBeSold, monsterTrucks);
//    }
//
//    private void sellAndRemoveVehicleOfType(Staff staff, Vehicle vehicle, List<Vehicle> listOfVehicleTypeSold, List<Vehicle> listOfVehicle) {
//        listOfVehicleTypeSold.remove(vehicle);
//        listOfVehicle.remove(vehicle);
//        soldVehicles.add(vehicle);
//        double saleBonus = vehicle.getSalesBonus();
//        updateStaffAmount(subscriberObject, saleBonus);
//        staff.setBonus(staff.getBonus() + saleBonus);
//    }
//
//    private void segregateVehiclesByType(List<Vehicle> vehiclesToBeSegregated) {
//        if(vehiclesToBeSegregated.equals(cars)) {
//            listToBeSegregated = carsToBeSold;
//        }
//        else if(vehiclesToBeSegregated.equals(performanceCars)) {
//            listToBeSegregated = pickupsToBeSold;
//        }
//        else if(vehiclesToBeSegregated.equals(pickups)) {
//            listToBeSegregated = pickupsToBeSold;
//        }
//        else if(vehiclesToBeSegregated.equals(electricCars)) {
//            listToBeSegregated = electricCarsToBeSold;
//        }
//        else if(vehiclesToBeSegregated.equals(motorcycles)) {
//            listToBeSegregated = motorcyclesToBeSold;
//        }
//        else if(vehiclesToBeSegregated.equals(monsterTrucks)){
//            listToBeSegregated = monsterTrucksToBeSold;
//        }
//
//        for(Vehicle vehicle : vehiclesToBeSegregated) {
//            if(vehicle.getCondition() != Condition.BROKEN) {
//                listToBeSegregated.add(vehicle);
//            }
//        }
//        sortCarsByCostPrice(listToBeSegregated);
//    }
//    private void sortCarsByCostPrice(List<Vehicle> list) {
//        Collections.sort(list, (obj1, obj2) -> (int) (obj2.getCostPrice() - obj1.getCostPrice()));
//    }
//}
