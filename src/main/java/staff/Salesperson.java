package main.java.staff;
/*
This class is for attributes of the Salesperson type - Inheritance
 */
import main.java.abstracts.Staff;
import main.java.functions.StaffName;

public class Salesperson extends Staff {
    public Salesperson() {
        this.salary = 300;
        this.name = "Salesperson-" + Staff.salespersonNumber;
        this.worked = false;
        this.totalDaysWorked = 0;
        this.bonus = 0;
    }

    public Salesperson(int totalDaysWorked, double bonus) {
        this.salary = 300;
        this.name = "Salesperson-" + Staff.salespersonNumber;
        this.worked = false;
        this.totalDaysWorked = totalDaysWorked;
        this.bonus = bonus;
    }
}
