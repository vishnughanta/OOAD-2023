package main.java.factories;

import main.java.abstracts.Staff;
import main.java.interfaces.FNCDFactory;
import main.java.staff.Driver;
import main.java.staff.Intern;
import main.java.staff.Mechanic;
import main.java.staff.Salesperson;

public class StaffFactory implements FNCDFactory<Staff> {
    @Override
    public Staff create(int type) {
        if(type == 1) {
            return new Intern();
        }
        else if(type == 2) {
            return new Mechanic();
        }
        else if(type == 3) {
            return new Salesperson();
        }
        else {
            return new Driver();
        }
    }
}
