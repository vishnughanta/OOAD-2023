package staff;

import abstracts.Staff;
import functions.StaffName;

public class Salesperson extends Staff {
    public Salesperson() {
        nameGenerator = new StaffName();
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
