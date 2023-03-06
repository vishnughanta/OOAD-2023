package main.java.activities;
/*
This class is for the Ending activity.
Contains all the methods for ending the day.
 */
import main.java.abstracts.Staff;
import main.java.functions.RandomNumberGenerator;
import main.java.printer.Printer;
import main.java.staff.Driver;
import main.java.staff.Mechanic;
import main.java.staff.Salesperson;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Ending extends Activity {
    public Ending() {
        System.out.println("Ending..");
        System.out.println();
        randomGenerator = new RandomNumberGenerator();
        printer = new Printer();
        calculatePayByDay();
        quitStaff();
        System.out.println();
        generateDailyReport();
        dailyDepartingStaff = new ArrayList<>();
        dailySoldVehicles = new ArrayList<>();
        dailySales = 0;
        System.out.println();
    }

    private void generateDailyReport() {
        printer.printDailyReport(interns, mechanics, salespersons, drivers, cars, performanceCars, pickups, electricCars, motorcycles, monsterTrucks, dailyDepartingStaff, dailySoldVehicles, dailySales, subscriberObject);
    }

    private void quitStaff() {
        quitMechanics();
        quitSalesperson();
        quitInterns();
        quitDrivers();
    }

    private void quitDrivers() {
        Iterator<Staff> iterator = drivers.iterator();
        while(iterator.hasNext()) {
            Driver driver = (Driver)iterator.next();
            if(driver.isInjured()) {
                iterator.remove();
                departedStaff.add(driver);
                dailyDepartingStaff.add(driver);
                printer.printQuitStaff(driver, subscriberObject);
            }
        }
    }

    private void quitMechanics() {
        int randomNumber = randomGenerator.generateRandomNumber(1,100);

        if(randomNumber >=1 && randomNumber <= 10) {
            randomNumber = randomGenerator.generateRandomNumber(0,2);
            Staff removedMechanic = mechanics.get(randomNumber);

            mechanics.remove(removedMechanic);
            departedStaff.add(removedMechanic);
            dailyDepartingStaff.add(removedMechanic);

            randomNumber = randomGenerator.generateRandomNumber(0, interns.size()-1);
            Staff addedIntern = interns.get(randomNumber);
            interns.remove(addedIntern);

            Staff newMechanic = new Mechanic(addedIntern.getTotalDaysWorked(), addedIntern.getBonus());
            Staff.mechanicNumber++;
            printer.printQuitStaff(removedMechanic, subscriberObject);
            printer.printPromotedStaff(addedIntern, newMechanic, subscriberObject);
            mechanics.add(newMechanic);
        }
    }

    private void quitSalesperson() {
        int randomNumber = randomGenerator.generateRandomNumber(1,100);
        if(randomNumber >=1 && randomNumber <= 10) {
            randomNumber = randomGenerator.generateRandomNumber(0,2);
            Staff removedSalesperson = salespersons.get(randomNumber);

            salespersons.remove(removedSalesperson);
            departedStaff.add(removedSalesperson);
            dailyDepartingStaff.add(removedSalesperson);

            randomNumber = randomGenerator.generateRandomNumber(0, interns.size()-1);
            Staff addedIntern = interns.get(randomNumber);

            interns.remove(addedIntern);
            Staff newSalesperson = new Salesperson(addedIntern.getTotalDaysWorked(), addedIntern.getBonus());
            Staff.salespersonNumber++;

            printer.printQuitStaff(removedSalesperson, subscriberObject);
            printer.printPromotedStaff(addedIntern, newSalesperson, subscriberObject);
            salespersons.add(newSalesperson);
        }
    }

    private void quitInterns() {
        int randomNumber = randomGenerator.generateRandomNumber(1,100);
        if(randomNumber >=1 && randomNumber <= 10) {
            randomNumber = randomGenerator.generateRandomNumber(0, interns.size()-1);
            Staff removedIntern = interns.get(randomNumber);
            interns.remove(removedIntern);
            departedStaff.add(removedIntern);
            dailyDepartingStaff.add(removedIntern);
            printer.printQuitStaff(removedIntern, subscriberObject);
        }
    }

    private void calculatePayByDay() {
        calculateStaffPayByType();
    }

    private void calculateStaffPayByType() {
        List<Staff> staffList = new ArrayList<>();
        staffList.addAll(interns);
        staffList.addAll(mechanics);
        staffList.addAll(salespersons);
        staffList.addAll(drivers);

        for(Staff staff : staffList) {
            if(staff.isWorked()) {
                while(getBudget() < staff.getSalary()) {
                    modifyOperatingBudget();
                }
                double salary = staff.getSalary();
                updateStaffAmount(subscriberObject, salary);
                setBudget(getBudget() - salary);
                staff.setTotalDaysWorked(staff.getTotalDaysWorked() + 1);
                staff.setCummSalary(staff.getCummSalary() + staff.getSalary());
                staff.setWorked(false);
            }
        }
    }
}
