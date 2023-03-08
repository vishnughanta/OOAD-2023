package main.java.staff;
/*
This class is for attributes of the Mechanic type.
 */
import main.java.abstracts.Staff;
import main.java.activities.Activity;

public class Mechanic extends Staff {
    public Mechanic(Activity activity) {
        this.salary = 200;
        this.name = "Mechanic-" + activity.getMechanicID();
        activity.setMechanicID(activity.getMechanicID() + 1);
        this.worked = false;
        this.totalDaysWorked = 0;
        this.bonus = 0;
    }

    public Mechanic(int totalDaysWorked, double bonus, Activity activity) {
        this.salary = 200;
        this.name = "Mechanic-" + activity.getMechanicID();
        activity.setMechanicID(activity.getMechanicID() + 1);
        this.worked = false;
        this.totalDaysWorked = totalDaysWorked;
        this.bonus = bonus;
    }
}
