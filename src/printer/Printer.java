package printer;

import abstracts.Staff;
import abstracts.Vehicle;
import enums.Cleanliness;
import enums.Condition;

import java.util.ArrayList;
import java.util.List;

public class Printer {
    public void printDailyReport(List<Staff> interns, List<Staff> mechanics, List<Staff> salespersons, List<Vehicle> cars, List<Vehicle> performanceCars, List<Vehicle> pickups, List<Staff> dailyDepartingStaff, List<Vehicle> dailySoldVehicles, double dailySales) {
        System.out.println("Daily Report..");
        System.out.println();
        List<Staff> workingStaff = new ArrayList<>();

        workingStaff.addAll(interns);
        workingStaff.addAll(mechanics);
        workingStaff.addAll(salespersons);
        printStaffDetails(workingStaff, dailyDepartingStaff);

        List<Vehicle> vehiclesInInventory = new ArrayList<>();
        vehiclesInInventory.addAll(cars);
        vehiclesInInventory.addAll(performanceCars);
        vehiclesInInventory.addAll(pickups);

        printVehicleDetails(vehiclesInInventory, dailySoldVehicles);

        System.out.println("Total sales for the day: " + dailySales);

    }

    private void printVehicleDetails(List<Vehicle> vehiclesInInventory, List<Vehicle> dailySoldVehicles) {
        System.out.println("Vehicles In Inventory:");

        for(Vehicle vehicle : vehiclesInInventory) {
            System.out.println(vehicle.getName() + "\t" +"\t" +"\t" + vehicle.getCostPrice() + "\t" + vehicle.getSalePrice() + "\t" + getCleanlinessOfVehicle(vehicle) + "\t" + getConditionOfVehicle(vehicle) + "\t" + "In Stock");
        }

        System.out.println();
        System.out.println("Sold Vehicles:");

        if(!dailySoldVehicles.isEmpty()) {
            for (Vehicle vehicle : dailySoldVehicles) {
                System.out.println(vehicle.getName() + "\t"  +"\t"+ vehicle.getCostPrice() + "\t" + vehicle.getSalePrice() + "\t" + getCleanlinessOfVehicle(vehicle) + "\t" + getConditionOfVehicle(vehicle) + "\t" + "Sold");

            }
        } else{
            System.out.println("No vehicle was sold in the FNCD today");
        }
    System.out.println();
    }

    private void printStaffDetails(List<Staff> workingStaff, List<Staff> dailyDepartingStaff) {
        System.out.println("Working Staff:");

        for(Staff staff : workingStaff) {
            System.out.println(staff.getName() + "\t" + "\t" + staff.getCummSalary() + "\t" + staff.getBonus() + "\t" + staff.getTotalDaysWorked());
        }
        System.out.println();
        System.out.println("Departed Staff:");

        if(!dailyDepartingStaff.isEmpty()) {
            for (Staff staff : dailyDepartingStaff) {
                System.out.println(staff.getName() + "\t" + "\t" + staff.getCummSalary() + "\t" + staff.getBonus() + "\t" + staff.getTotalDaysWorked());
            }
        }
        else {
            System.out.println("No one quit the FNCD today");
        }
        System.out.println();
    }

    public void printQuitStaff(Staff staff) {
        System.out.println(staff.getName() +" has quit the FNCD");
    }

    public void printPromotedStaff(Staff staff1, Staff staff2) {
        System.out.println(staff1.getName() +" has been promoted to " + staff2.getName());
    }

    public void printSoldVehicles(Staff staff, Vehicle vehicle) {
        System.out.println(staff.getName() +" has sold " + vehicle.getName() +" for a sale price of $" + vehicle.getSalePrice() +" (Earned a sale bonus of $" + vehicle.getSalesBonus() +")");

    }

    public void printRepairedVehicles(Staff staff, Vehicle vehicle, boolean hasRepaired) {
        if(hasRepaired) {
            System.out.print(staff.getName() + " has repaired " + vehicle.getName());
            System.out.print(" and made it " + getCleanlinessOfVehicle(vehicle) + " (Earned a bonus of $" + vehicle.getRepairBonus() +")");
        }
        else {
            System.out.print(staff.getName() + " has not repaired " + vehicle.getName());
        }
        System.out.println();
    }

    public void printWashedVehicles(Staff staff, Vehicle vehicle, boolean hasCleaned, boolean hasBonus) {
        System.out.print(staff.getName() + " has washed " + vehicle.getName());
        if(hasCleaned) System.out.print(" and made it " + getCleanlinessOfVehicle(vehicle));
        if(hasBonus) System.out.print(" (Earned a bonus of $" + vehicle.getWashBonus() +")");
        System.out.println();
    }

    public void printHiredStaffInOpening(Staff staff) {
        System.out.println("Hired "+staff.getName());
    }
    public void printPurchasedVehiclesInOpening(Vehicle vehicle) {
        System.out.println("Purchased " +
                getConditionOfVehicle(vehicle) + " " +
                getCleanlinessOfVehicle(vehicle) + " " +
                vehicle.getName() + " " +
                "for a cost price of " +
                vehicle.getCostPrice()
        );
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
}
