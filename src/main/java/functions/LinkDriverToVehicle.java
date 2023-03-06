package main.java.functions;

import main.java.abstracts.Vehicle;
import main.java.staff.Driver;


public class LinkDriverToVehicle {
    private Driver driver;
    private Vehicle vehicle;

    public LinkDriverToVehicle(Driver driver, Vehicle vehicle) {
        this.driver = driver;
        this.vehicle = vehicle;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
