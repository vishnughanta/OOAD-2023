package main.java.commands;

import main.java.abstracts.Vehicle;
import main.java.interfaces.Command;

import java.util.List;

public class DetailInventoryCommand implements Command {
    Vehicle vehicle;
    public DetailInventoryCommand(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
    @Override
    public void execute() {
        System.out.println("Congratulations! You have selected the following vehicle: " + vehicle.getName() + ". The details are as follows:");
        System.out.println("Name: " +  vehicle.getName());
        System.out.println("Cleanliness: " + vehicle.getCleanliness());
        System.out.println("Condition: " + vehicle.getCondition());
        System.out.println("Races won: " + vehicle.getRacesWon());
        System.out.println("Selling Price: " + vehicle.getSalePrice());
    }

    @Override
    public void undo() {

    }
}
