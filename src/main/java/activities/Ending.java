package main.java.activities;
/*
This class is for the Ending activity.
Contains all the methods for ending the day.
 */
import main.java.abstracts.Staff;
import main.java.functions.RandomNumberGenerator;
import main.java.interfaces.RandomGenerator;
import main.java.printer.Printer;
import main.java.staff.Driver;
import main.java.staff.Mechanic;
import main.java.staff.Salesperson;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Ending {
    private RandomGenerator randomGenerator;
    private Printer printer;
    public void startEnding(Activity activity) {
        System.out.println("Ending in " + activity.getNameOfFNCD() + "..");
        System.out.println();
        randomGenerator = new RandomNumberGenerator();
        printer = new Printer();
        calculatePayByDay(activity);
        quitStaff(activity);
        System.out.println();
        generateDailyReport(activity);
        activity.setDailyDepartingStaff(new ArrayList<>());
        activity.setDailySoldVehicles(new ArrayList<>());
        activity.setDailySales(0);
        System.out.println();

    }

    private void generateDailyReport(Activity activity) {
        printer.printDailyReport(activity.getInterns(), activity.getMechanics(), activity.getSalespersons(), activity.getDrivers(), activity.getCars(), activity.getPerformanceCars(), activity.getPickups(), activity.getElectricCars(), activity.getMotorcycles(), activity.getMonsterTrucks(), activity.getCoupes(), activity.getMinivans(), activity.getSuvs(), activity.getDailyDepartingStaff(), activity.getDailySoldVehicles(), activity.getDailySales(), activity.getSubscriberObject());
    }

    private void quitStaff(Activity activity) {
        quitMechanics(activity);
        quitSalesperson(activity);
        quitInterns(activity);
        quitDrivers(activity);
    }

    private void quitDrivers(Activity activity) {
        List<Staff> drivers = activity.getDrivers();
        Iterator<Staff> iterator = drivers.iterator();
        while(iterator.hasNext()) {
            Driver driver = (Driver)iterator.next();
            if(driver.isInjured()) {
                iterator.remove();

                List<Staff> departedStaff = activity.getDepartedStaff();
                departedStaff.add(driver);
                activity.setDepartedStaff(departedStaff);

                List<Staff> dailyDepartingStaff = activity.getDailyDepartingStaff();
                dailyDepartingStaff.add(driver);
                activity.setDailyDepartingStaff(dailyDepartingStaff);

                printer.printQuitStaff(driver, activity.getSubscriberObject());
            }
        }
    }

    private void quitMechanics(Activity activity) {
        int randomNumber = randomGenerator.generateRandomNumber(1,100);

        if(randomNumber >=1 && randomNumber <= 10) {
            randomNumber = randomGenerator.generateRandomNumber(0,2);
            List<Staff> mechanics = activity.getMechanics();
            Staff removedMechanic = mechanics.get(randomNumber);
            mechanics.remove(removedMechanic);
            activity.setMechanics(mechanics);

            List<Staff> departedStaff = activity.getDepartedStaff();
            departedStaff.add(removedMechanic);
            activity.setDepartedStaff(departedStaff);

            List<Staff> dailyDepartingStaff = activity.getDailyDepartingStaff();
            dailyDepartingStaff.add(removedMechanic);
            activity.setDailyDepartingStaff(dailyDepartingStaff);

            randomNumber = randomGenerator.generateRandomNumber(0, activity.getInterns().size()-1);

            List<Staff> interns = activity.getInterns();
            Staff addedIntern = interns.get(randomNumber);
            interns.remove(addedIntern);
            activity.setInterns(interns);

            Staff newMechanic = new Mechanic(addedIntern.getTotalDaysWorked(), addedIntern.getBonus(), activity);
            mechanics = activity.getMechanics();
            mechanics.add(newMechanic);
            activity.setMechanics(mechanics);
            printer.printQuitStaff(removedMechanic, activity.getSubscriberObject());
            printer.printPromotedStaff(addedIntern, newMechanic, activity.getSubscriberObject());
        }
    }

    private void quitSalesperson(Activity activity) {
        int randomNumber = randomGenerator.generateRandomNumber(1,100);
        if(randomNumber >=1 && randomNumber <= 10) {
            randomNumber = randomGenerator.generateRandomNumber(0,2);

            List<Staff> salespersons = activity.getSalespersons();
            Staff removedSalesperson = salespersons.get(randomNumber);
            salespersons.remove(removedSalesperson);
            activity.setSalespersons(salespersons);

            List<Staff> departedStaff = activity.getDepartedStaff();
            departedStaff.add(removedSalesperson);
            activity.setDepartedStaff(departedStaff);

            List<Staff> dailyDepartingStaff = activity.getDailyDepartingStaff();
            dailyDepartingStaff.add(removedSalesperson);
            activity.setDailyDepartingStaff(dailyDepartingStaff);

            randomNumber = randomGenerator.generateRandomNumber(0, activity.getInterns().size()-1);
            List<Staff> interns = activity.getInterns();
            Staff addedIntern = interns.get(randomNumber);
            interns.remove(addedIntern);
            activity.setInterns(interns);

            Staff newSalesperson = new Salesperson(addedIntern.getTotalDaysWorked(), addedIntern.getBonus(), activity);
            salespersons = activity.getSalespersons();
            salespersons.add(newSalesperson);
            activity.setSalespersons(salespersons);

            printer.printQuitStaff(removedSalesperson, activity.getSubscriberObject());
            printer.printPromotedStaff(addedIntern, newSalesperson, activity.getSubscriberObject());
        }
    }

    private void quitInterns(Activity activity) {
        int randomNumber = randomGenerator.generateRandomNumber(1,100);
        if(randomNumber >=1 && randomNumber <= 10) {
            randomNumber = randomGenerator.generateRandomNumber(0, activity.getInterns().size()-1);
            List<Staff> interns = activity.getInterns();
            Staff removedIntern = interns.get(randomNumber);
            interns.remove(removedIntern);
            activity.setInterns(interns);

            List<Staff> departedStaff = activity.getDepartedStaff();
            departedStaff.add(removedIntern);
            activity.setDepartedStaff(departedStaff);

            List<Staff> dailyDepartingStaff = activity.getDailyDepartingStaff();
            dailyDepartingStaff.add(removedIntern);
            activity.setDailyDepartingStaff(dailyDepartingStaff);

            printer.printQuitStaff(removedIntern, activity.getSubscriberObject());
        }
    }

    private void calculatePayByDay(Activity activity) {
        calculateStaffPayByType(activity);
    }

    private void calculateStaffPayByType(Activity activity) {
        List<Staff> staffList = new ArrayList<>();
        staffList.addAll(activity.getInterns());
        staffList.addAll(activity.getMechanics());
        staffList.addAll(activity.getSalespersons());
        staffList.addAll(activity.getDrivers());

        for(Staff staff : staffList) {
            if(staff.isWorked()) {
                while(activity.getBudget() < staff.getSalary()) {
                    activity.modifyOperatingBudget(activity);
                }
                double salary = staff.getSalary();
                activity.updateStaffAmount(activity.getSubscriberObject(), salary);
                activity.setBudget(activity.getBudget() - salary);
                staff.setTotalDaysWorked(staff.getTotalDaysWorked() + 1);
                staff.setCummSalary(staff.getCummSalary() + staff.getSalary());
                staff.setWorked(false);
            }
        }
    }
}
