package main.java.printer;

import main.java.abstracts.Staff;
import main.java.abstracts.Vehicle;
import main.java.enums.Cleanliness;
import main.java.enums.Condition;
import main.java.functions.LinkDriverToVehicle;
import main.java.staff.Driver;
import main.java.subscriber.SubscriberObject;

import java.util.ArrayList;
import java.util.List;

public class Printer {
    String stringToBeAppended;

    public Printer() {
        stringToBeAppended = "";
    }
    public void printDailyReport(List<Staff> interns, List<Staff> mechanics, List<Staff> salespersons, List<Staff> drivers, List<Vehicle> cars, List<Vehicle> performanceCars, List<Vehicle> pickups, List<Vehicle> electricCars, List<Vehicle> motorcycles, List<Vehicle> monsterTrucks, List<Vehicle> coupes, List<Vehicle> minivans, List<Vehicle> suvs, List<Staff> dailyDepartingStaff, List<Vehicle> dailySoldVehicles, double dailySales, SubscriberObject subscriberObject) {
        stringToBeAppended = "Daily Report.." + System.lineSeparator();
        updateLogList(subscriberObject, stringToBeAppended);
        System.out.println(stringToBeAppended);


        List<Staff> workingStaff = new ArrayList<>();

        workingStaff.addAll(interns);
        workingStaff.addAll(mechanics);
        workingStaff.addAll(salespersons);
        workingStaff.addAll(drivers);
        printStaffDetails(workingStaff, dailyDepartingStaff, subscriberObject);

        List<Vehicle> vehiclesInInventory = new ArrayList<>();
        vehiclesInInventory.addAll(cars);
        vehiclesInInventory.addAll(performanceCars);
        vehiclesInInventory.addAll(pickups);
        vehiclesInInventory.addAll(electricCars);
        vehiclesInInventory.addAll(motorcycles);
        vehiclesInInventory.addAll(monsterTrucks);
        vehiclesInInventory.addAll(coupes);
        vehiclesInInventory.addAll(minivans);
        vehiclesInInventory.addAll(suvs);

        printVehicleDetails(vehiclesInInventory, dailySoldVehicles, subscriberObject);

        System.out.println("Total sales for the day: " + dailySales);

    }

    private void printVehicleDetails(List<Vehicle> vehiclesInInventory, List<Vehicle> dailySoldVehicles, SubscriberObject subscriberObject) {
        stringToBeAppended = "Vehicles In Inventory:";
        updateLogList(subscriberObject,stringToBeAppended);
        System.out.println(stringToBeAppended);

        for(Vehicle vehicle : vehiclesInInventory) {
            stringToBeAppended = vehicle.getName() + "\t" +"\t" +"\t" + vehicle.getCostPrice() + "\t" + vehicle.getFinalSalePrice() + "\t" + getCleanlinessOfVehicle(vehicle) + "\t" + getConditionOfVehicle(vehicle) + "\t" + "In Stock";
            updateLogList(subscriberObject,stringToBeAppended);
            System.out.println(stringToBeAppended);
        }

        System.out.println();
        stringToBeAppended = "Sold Vehicles:";
        updateLogList(subscriberObject, stringToBeAppended);
        System.out.println(stringToBeAppended);

        if(!dailySoldVehicles.isEmpty()) {
            for (Vehicle vehicle : dailySoldVehicles) {
                stringToBeAppended = vehicle.getName() + "\t"  +"\t"+ vehicle.getCostPrice() + "\t" + vehicle.getFinalSalePrice() + "\t" + getCleanlinessOfVehicle(vehicle) + "\t" + getConditionOfVehicle(vehicle) + "\t" + "Sold";
                updateLogList(subscriberObject, stringToBeAppended);
                System.out.println(stringToBeAppended);
            }
        } else{
            stringToBeAppended = "No vehicle was sold in the FNCD today";
            updateLogList(subscriberObject, stringToBeAppended);
            System.out.println(stringToBeAppended);
        }
    System.out.println();
    }

    private void printStaffDetails(List<Staff> workingStaff, List<Staff> dailyDepartingStaff, SubscriberObject subscriberObject) {
        stringToBeAppended = "Working Staff:";
        updateLogList(subscriberObject, stringToBeAppended);

        for(Staff staff : workingStaff) {
            stringToBeAppended = staff.getName() + "\t" + "\t" + staff.getCummSalary() + "\t" + staff.getBonus() + "\t" + staff.getTotalDaysWorked();
            updateLogList(subscriberObject, stringToBeAppended);
            System.out.println(stringToBeAppended);
        }
        System.out.println();
        stringToBeAppended = "Departed Staff:";
        updateLogList(subscriberObject, stringToBeAppended);
        System.out.println(stringToBeAppended);

        if(!dailyDepartingStaff.isEmpty()) {
            for (Staff staff : dailyDepartingStaff) {
                stringToBeAppended = staff.getName() + "\t" + "\t" + staff.getCummSalary() + "\t" + staff.getBonus() + "\t" + staff.getTotalDaysWorked();
                updateLogList(subscriberObject, stringToBeAppended);
                System.out.println(stringToBeAppended);
            }
        }
        else {
            stringToBeAppended = "No one quit the FNCD today";
            updateLogList(subscriberObject, stringToBeAppended);
            System.out.println(stringToBeAppended);
        }
        System.out.println();
    }

    public void printQuitStaff(Staff staff, SubscriberObject subscriberObject) {
        stringToBeAppended = staff.getName() +" has quit the FNCD";
        updateLogList(subscriberObject, stringToBeAppended);
        System.out.println(stringToBeAppended);
    }

    public void printPromotedStaff(Staff staff1, Staff staff2, SubscriberObject subscriberObject) {
        stringToBeAppended = staff1.getName() +" has been promoted to " + staff2.getName();
        updateLogList(subscriberObject, stringToBeAppended);
        System.out.println(stringToBeAppended);
    }

    public void printSoldVehicles(Staff staff, Vehicle vehicle, SubscriberObject subscriberObject) {
        stringToBeAppended = staff.getName() +" has sold " + vehicle.getName() +" for a sale price of $" + vehicle.getFinalSalePrice() +" (Earned a sale bonus of $" + vehicle.getSalesBonus() +")";
        updateLogList(subscriberObject, stringToBeAppended);
        System.out.println(stringToBeAppended);
    }

    public void printRepairedVehicles(Staff staff, Vehicle vehicle, boolean hasRepaired, SubscriberObject subscriberObject) {
        if(hasRepaired) {
            stringToBeAppended = staff.getName() + " has repaired " + vehicle.getName() + " and made it " + getCleanlinessOfVehicle(vehicle) + " (Earned a bonus of $" + vehicle.getRepairBonus() +")";
            updateLogList(subscriberObject, stringToBeAppended);
            System.out.print(stringToBeAppended);
        }
        else {
            stringToBeAppended = staff.getName() + " has not repaired " + vehicle.getName();
            updateLogList(subscriberObject, stringToBeAppended);
            System.out.print(stringToBeAppended);
        }
        System.out.println();
    }

    public void printWashedVehicles(Staff staff, Vehicle vehicle, boolean hasCleaned, boolean hasBonus, SubscriberObject subscriberObject) {
        stringToBeAppended = staff.getName() + " has washed " + vehicle.getName();
        if(hasCleaned) {
            stringToBeAppended += " and made it " + getCleanlinessOfVehicle(vehicle);
        }
        if(hasBonus) {
            stringToBeAppended += " (Earned a bonus of $" + vehicle.getWashBonus() +")";
        }
        updateLogList(subscriberObject, stringToBeAppended);
        System.out.println(stringToBeAppended);
    }

    public void printHiredStaffInOpening(Staff staff, SubscriberObject subscriberObject) {
        stringToBeAppended = "Hired "+staff.getName();
        updateLogList(subscriberObject, stringToBeAppended);
        System.out.println(stringToBeAppended);
    }
    public void printPurchasedVehiclesInOpening(Vehicle vehicle, SubscriberObject subscriberObject) {
        stringToBeAppended = "Purchased " + getConditionOfVehicle(vehicle) + " " + getCleanlinessOfVehicle(vehicle) + " " + vehicle.getName() + " " + "for a cost price of " + vehicle.getCostPrice();
        updateLogList(subscriberObject, stringToBeAppended);
        System.out.println(stringToBeAppended);
    }

    public String getConditionOfVehicle(Vehicle vehicle) {
        if(vehicle.getCondition() == Condition.BROKEN) return "Broken";
        else if(vehicle.getCondition() == Condition.NEW) return "New";
        else return "Used";
    }

    public String getCleanlinessOfVehicle(Vehicle vehicle) {
        if(vehicle.getCleanliness() == Cleanliness.CLEAN) return "Clean";
        else if(vehicle.getCleanliness() == Cleanliness.SPARKLING) return "Sparkling";
        else return "Dirty";
    }

    public void printFirstRacePositions(LinkDriverToVehicle linkDriverToVehicle, int position, SubscriberObject subscriberObject) {
        Driver driver = linkDriverToVehicle.getDriver();
        Vehicle vehicle = linkDriverToVehicle.getVehicle();
        stringToBeAppended = "Top 3 positions: "+ driver.getName() + " with " + vehicle.getName() + " has finished in " + position + " position";
        updateLogList(subscriberObject, stringToBeAppended);
        System.out.println(stringToBeAppended);
    }

    public void printLastRacePositions(LinkDriverToVehicle linkDriverToVehicle, int position, SubscriberObject subscriberObject) {
        Driver driver = linkDriverToVehicle.getDriver();
        Vehicle vehicle = linkDriverToVehicle.getVehicle();
        stringToBeAppended ="Last 5 Positions: " + driver.getName() + " with " + vehicle.getName() + " has finished in " + position + " position";
        updateLogList(subscriberObject, stringToBeAppended);
        System.out.println(stringToBeAppended);
    }

    public void updateLogList(SubscriberObject subscriberObject, String stringToBeAppended) {
        List<String> existingLogList = subscriberObject.getLogList();
        existingLogList.add(stringToBeAppended);
        subscriberObject.setLogList(existingLogList);
    }
}
