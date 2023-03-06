package main.java.staff;
/*
This class is for attributes of the Mechanic type.
 */
import main.java.abstracts.Staff;

public class Mechanic extends Staff {
    public Mechanic() {
        this.salary = 200;
        this.name = "Mechanic-" +Staff.mechanicNumber;
        this.worked = false;
        this.totalDaysWorked = 0;
        this.bonus = 0;
    }

    public Mechanic(int totalDaysWorked, double bonus) {
        this.salary = 200;
        this.name = "Mechanic-" +Staff.mechanicNumber;
        this.worked = false;
        this.totalDaysWorked = totalDaysWorked;
        this.bonus = bonus;
    }
}
