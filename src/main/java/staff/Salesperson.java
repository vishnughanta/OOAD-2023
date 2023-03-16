package main.java.staff;
/*
This class is for attributes of the Salesperson type - Inheritance
 */
import main.java.abstracts.Staff;
import main.java.activities.Activity;


public class Salesperson extends Staff {
    public Salesperson(Activity activity) {
        this.salary = 300;
        this.name = "Salesperson-" + Activity.getSalespersonID();
        Activity.setSalespersonID(Activity.getSalespersonID() + 1);
        this.worked = false;
        this.totalDaysWorked = 0;
        this.bonus = 0;
    }

    public Salesperson(int totalDaysWorked, double bonus, Activity activity) {
        this.salary = 300;
        this.name = "Salesperson-" + Activity.getSalespersonID();
        Activity.setSalespersonID(Activity.getSalespersonID() + 1);
        this.worked = false;
        this.totalDaysWorked = totalDaysWorked;
        this.bonus = bonus;
    }
}
