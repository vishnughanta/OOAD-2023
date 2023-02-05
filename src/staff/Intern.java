package staff;

import functions.StaffName;
import interfaces.NameGenerator;

public class Intern extends Staff {
    public Intern(){
        nameGenerator = new StaffName();
        this.salary = 100;
        this.name = nameGenerator.generateName();
        this.worked = false;
    }
}
