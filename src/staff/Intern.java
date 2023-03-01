package staff;
/*
This class is for attributes of the Intern type.
 */
import abstracts.Staff;
import enums.WashingMethod;
import functions.RandomNumberGenerator;
import functions.StaffName;
import interfaces.RandomGenerator;

public class Intern extends Staff {
    private WashingMethod washingMethod;

    public Intern(){
        nameGenerator = new StaffName();
        this.salary = 100;
        this.name = "Intern-" + Staff.internNumber;
        this.worked = false;
        this.totalDaysWorked = 0;
        this.bonus = 0;
        RandomGenerator randomGenerator = new RandomNumberGenerator();

        int washingMethodChance = randomGenerator.generateRandomNumber(0,2);
        if(washingMethodChance == 0) setWashingMethod(WashingMethod.CHEMICAL);
        else if(washingMethodChance == 1) setWashingMethod(WashingMethod.DETAILED);
        else setWashingMethod(WashingMethod.ELBOW_GREASE);

        //added new comments
    }

    public WashingMethod getWashingMethod() {
        return washingMethod;
    }

    public void setWashingMethod(WashingMethod washingMethod) {
        this.washingMethod = washingMethod;
    }
}
