package main.java.commands;

import main.java.abstracts.Staff;
import main.java.abstracts.Vehicle;
import main.java.activities.Activity;
import main.java.activities.Selling;
import main.java.interfaces.Command;

public class BuyInventoryCommand implements Command {
    Staff salesperson;
    Activity activity;
    Vehicle vehicle;
    public BuyInventoryCommand(Staff salesperson, Activity activity, Vehicle vehicle) {
        this.salesperson = salesperson;
        this.activity = activity;
        this.vehicle = vehicle;
    }

    @Override
    public void execute() {
        Selling selling = new Selling(activity);
        selling.setCommandLine(true);
        selling.sellVehicleHelper(salesperson, vehicle, activity);
    }

    @Override
    public void undo() {

    }
}
