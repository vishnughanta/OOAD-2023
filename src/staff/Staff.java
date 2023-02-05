package staff;

import interfaces.NameGenerator;

abstract class Staff {
    protected NameGenerator nameGenerator;
    protected String name;
    protected double salary;
    protected double bonus;
    protected int totalDaysWorked;
    protected boolean worked;

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
}
