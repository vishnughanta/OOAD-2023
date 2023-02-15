package activities;

import abstracts.Staff;
import functions.RandomNumberGenerator;
import staff.Mechanic;
import staff.Salesperson;

public class Ending extends Activity {
    public Ending() {
        System.out.println("Ending..");
        System.out.println();
        randomGenerator = new RandomNumberGenerator();
        calculatePayByDay();
        quitStaff();
        System.out.println();
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
            System.out.println(removedMechanic.getName() + " has quit the FNCD");

            randomNumber = randomGenerator.generateRandomNumber(0, interns.size()-1);
            Staff addedIntern = interns.get(randomNumber);
            interns.remove(addedIntern);

            Staff newMechanic = new Mechanic(addedIntern.getTotalDaysWorked(), addedIntern.getBonus());
            Staff.mechanicNumber++;
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
            System.out.println(removedSalesperson.getName() + " has quit the FNCD");
            randomNumber = randomGenerator.generateRandomNumber(0, interns.size()-1);
            Staff addedIntern = interns.get(randomNumber);
            interns.remove(addedIntern);
            Staff newSalesperson = new Salesperson(addedIntern.getTotalDaysWorked(), addedIntern.getBonus());
            Staff.salespersonNumber++;
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
            }
        }
    }

}
