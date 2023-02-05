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
    }
}
