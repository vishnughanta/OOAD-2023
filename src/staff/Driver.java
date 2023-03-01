package staff;

import abstracts.Staff;

public class Driver extends Staff {
    private int racesWon;
    public Driver() {
        setSalary(350);
        setName("Driver-" + Staff.driverNumber);
        setWorked(false);
        setTotalDaysWorked(0);
        setBonus(0);
        setRacesWon(0);
    }

    public int getRacesWon() {
        return racesWon;
    }

    public void setRacesWon(int racesWon) {
        this.racesWon = racesWon;
    }
}
