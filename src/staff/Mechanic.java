package staff;

import abstracts.Staff;
import functions.StaffName;

public class Mechanic extends Staff {
    public Mechanic() {
        nameGenerator = new StaffName();
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
