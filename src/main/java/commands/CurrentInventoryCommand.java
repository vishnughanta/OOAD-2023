package main.java.commands;

import main.java.abstracts.Vehicle;
import main.java.interfaces.Command;

import java.util.List;

public class CurrentInventoryCommand implements Command {
    private List<Vehicle> inventoryList;
    public CurrentInventoryCommand(List<Vehicle> inventoryList) {
        this.inventoryList = inventoryList;
    }
    @Override
    public void execute() {
        System.out.println("The current inventory in the selected FNCD is:");
        int index = 1;
        for(Vehicle vehicle : inventoryList) {
            System.out.println(index + ": " + vehicle.getName());
            index++;
        }
    }

    @Override
    public void undo() {

    }
}
