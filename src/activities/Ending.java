package activities;

import abstracts.Staff;
import functions.RandomNumberGenerator;

public class Ending extends Activity {
    public Ending() {
        randomGenerator = new RandomNumberGenerator();
        calculatePayByDay();
        quitStaff();
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
            randomNumber = randomGenerator.generateRandomNumber(0, interns.size()-1);
            Staff addedIntern = interns.get(randomNumber);
            interns.remove(addedIntern);
            mechanics.add(addedIntern);
        }
    }

    private void quitSalesperson() {
        int randomNumber = randomGenerator.generateRandomNumber(1,100);
        if(randomNumber >=1 && randomNumber <= 10) {
            randomNumber = randomGenerator.generateRandomNumber(0,2);
            Staff removedSalesperson = salespersons.get(randomNumber);
            salespersons.remove(removedSalesperson);
            departedStaff.add(removedSalesperson);
            randomNumber = randomGenerator.generateRandomNumber(0, interns.size()-1);
            Staff addedIntern = interns.get(randomNumber);
            interns.remove(addedIntern);
            salespersons.add(addedIntern);
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
                setBudget(getBudget() - salesperson.getSalary());
                salesperson.setTotalDaysWorked(salesperson.getTotalDaysWorked() + 1);
            }
        }
    }

    private void calculateMechanicsPay() {
        for(Staff mechanic : mechanics) {
            if(mechanic.isWorked()) {
                setBudget(getBudget() - mechanic.getSalary());
                mechanic.setTotalDaysWorked(mechanic.getTotalDaysWorked() + 1);
            }
        }
    }

    private void calculateInternsPay() {
        for(Staff intern : interns) {
            if(intern.isWorked()) {
                setBudget(getBudget() - intern.getSalary());
                intern.setTotalDaysWorked(intern.getTotalDaysWorked() + 1);
            }
        }
    }

}
