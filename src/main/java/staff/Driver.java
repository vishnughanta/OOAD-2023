package main.java.staff;

import main.java.abstracts.Staff;
import main.java.activities.Activity;
import main.java.interfaces.FNCDFactory;

public class Driver extends Staff {
    private int racesWon;
    private boolean isInjured;
    public Driver(Activity activity) {
        setSalary(350);
        setName("Driver-" + activity.getDriverID());
        Activity.setDriverID(Activity.getDriverID() + 1);
        setWorked(false);
        setTotalDaysWorked(0);
        setBonus(0);
        setRacesWon(0);
        setInjured(false);
    }

    public int getRacesWon() {
        return racesWon;
    }

    public void setRacesWon(int racesWon) {
        this.racesWon = racesWon;
    }

    public boolean isInjured() {
        return isInjured;
    }

    public void setInjured(boolean injured) {
        isInjured = injured;
    }
}
