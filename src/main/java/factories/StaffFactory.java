package main.java.factories;

import main.java.abstracts.Staff;
import main.java.activities.Activity;
import main.java.interfaces.FNCDFactory;
import main.java.staff.Driver;
import main.java.staff.Intern;
import main.java.staff.Mechanic;
import main.java.staff.Salesperson;

public class StaffFactory implements FNCDFactory<Staff> {
    @Override
    public Staff create(int type, Activity activity) {
        if(type == 1) {
            return new Intern(activity);
        }
        else if(type == 2) {
            return new Mechanic(activity);
        }
        else if(type == 3) {
            return new Salesperson(activity);
        }
        else {
            return new Driver(activity);
        }
    }
}
