package staff;
/*
This class is for attributes of the Intern type.
 */
import abstracts.Staff;
import functions.StaffName;

public class Intern extends Staff {
    public Intern(){
        nameGenerator = new StaffName();
        this.salary = 100;
        this.name = "Intern-" + Staff.internNumber;
        this.worked = false;
        this.totalDaysWorked = 0;
        this.bonus = 0;
    }
}
