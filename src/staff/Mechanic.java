package staff;

import abstracts.Staff;
import functions.StaffName;

public class Mechanic extends Staff {
    public Mechanic() {
        nameGenerator = new StaffName();
        this.salary = 200;
        this.name = nameGenerator.generateName();
        this.worked = false;
        this.totalDaysWorked = 0;
        this.bonus = 0;
    }

    public Mechanic(String name, int totalDaysWorked, double bonus) {
        this.salary = 200;
        this.name = name;
        this.worked = false;
        this.totalDaysWorked = totalDaysWorked;
        this.bonus = bonus;
    }
}
