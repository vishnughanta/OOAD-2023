package staff;

import abstracts.Staff;
import functions.StaffName;

public class Salesperson extends Staff {
    public Salesperson() {
        nameGenerator = new StaffName();
        this.salary = 300;
        this.name = nameGenerator.generateName();
        this.worked = false;
        this.totalDaysWorked = 0;
    }
}
