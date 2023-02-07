package staff;

import abstracts.Staff;
import functions.StaffName;

public class Intern extends Staff {
    public Intern(){
        nameGenerator = new StaffName();
        this.salary = 100;
        this.name = nameGenerator.generateName();
        this.worked = false;
        this.totalDaysWorked = 0;
        this.bonus = 0;
    }
}
