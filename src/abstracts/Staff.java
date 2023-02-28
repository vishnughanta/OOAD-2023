package abstracts;
/*
This abstract class is the parent of all the types of Staff.
 */
import interfaces.NameGenerator;

public abstract class Staff {
    public static int internNumber = 0;
    public static int mechanicNumber = 0;
    public static int salespersonNumber = 0;
    public static int driverNumber = 0;
    protected NameGenerator nameGenerator;
    protected String name;
    protected double salary;
    protected double bonus;
    protected int totalDaysWorked;
    protected boolean worked;
    protected double cummSalary;
    protected double cummBonus;
    /*
    Getters and setter methods
    This supports ENCAPSULATION.
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public int getTotalDaysWorked() {
        return totalDaysWorked;
    }

    public void setTotalDaysWorked(int totalDaysWorked) {
        this.totalDaysWorked = totalDaysWorked;
    }

    public boolean isWorked() {
        return worked;
    }

    public void setWorked(boolean worked) {
        this.worked = worked;
    }

    public double getCummSalary() {
        return cummSalary;
    }

    public void setCummSalary(double cummSalary) {
        this.cummSalary = cummSalary;
    }

    public double getCummBonus() {
        return cummBonus;
    }

    public void setCummBonus(double cummBonus) {
        this.cummBonus = cummBonus;
    }
}
