package staff;

import abstracts.Staff;
import functions.StaffName;

public class Driver extends Staff {
    public Driver() {
        nameGenerator = new StaffName();
        this.salary = 100;
        this.name = "Driver-" + Staff.driverNumber;
        this.worked = false;
        this.totalDaysWorked = 0;
        this.bonus = 0;
    }
}
