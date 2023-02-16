package activities;

import abstracts.Staff;
import functions.RandomNumberGenerator;
import printer.Printer;
import staff.Mechanic;
import staff.Salesperson;

import java.util.ArrayList;

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
        printer.printDailyReport(interns, mechanics, salespersons, cars, performanceCars, pickups, dailyDepartingStaff, dailySoldVehicles, dailySales);
    }

    private void quitStaff() {
        quitMechanics();
        quitSalesperson();
        quitInterns();
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
            printer.printQuitStaff(removedMechanic);
            printer.printPromotedStaff(addedIntern, newMechanic);
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

            printer.printQuitStaff(removedSalesperson);
            printer.printPromotedStaff(addedIntern, newSalesperson);
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
            printer.printQuitStaff(removedIntern);
        }
    }

    private void calculatePayByDay() {
        calculateInternsPay();
        calculateMechanicsPay();
        calculateSalespersonsPay();
    }

    private void calculateSalespersonsPay() {
        for(Staff salesperson : salespersons) {
            if(salesperson.isWorked()) {
                if(getBudget() < salesperson.getSalary()) {
                    modifyOperatingBudget();
                }
                setBudget(getBudget() - salesperson.getSalary());
                salesperson.setTotalDaysWorked(salesperson.getTotalDaysWorked() + 1);
                salesperson.setCummSalary(salesperson.getCummSalary() + salesperson.getSalary());
                salesperson.setWorked(false);
            }
        }
    }

    private void calculateMechanicsPay() {
        for(Staff mechanic : mechanics) {
            if(mechanic.isWorked()) {
                if(getBudget() < mechanic.getSalary()) {
                    modifyOperatingBudget();
                }
                setBudget(getBudget() - mechanic.getSalary());
                mechanic.setTotalDaysWorked(mechanic.getTotalDaysWorked() + 1);
                mechanic.setCummSalary(mechanic.getCummSalary() + mechanic.getSalary());
                mechanic.setWorked(false);
            }
        }
    }

    private void calculateInternsPay() {
        for(Staff intern : interns) {
            if(intern.isWorked()) {
                if(getBudget() < intern.getSalary()) {
                    modifyOperatingBudget();
                }
                setBudget(getBudget() - intern.getSalary());
                intern.setTotalDaysWorked(intern.getTotalDaysWorked() + 1);
                intern.setCummSalary(intern.getCummSalary() + intern.getSalary());
                intern.setWorked(false);
            }
        }
    }

}
