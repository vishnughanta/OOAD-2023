package main.java.commands;

import main.java.abstracts.Staff;
import main.java.interfaces.Command;

public class SalespersonNameCommand implements Command {
    private Staff salesperson;
    public SalespersonNameCommand(Staff salesperson) {
        this.salesperson = salesperson;
    }
    @Override
    public void execute() {
        System.out.println("The name of the Salesperson assigned to you is " + salesperson.getName());
    }

    @Override
    public void undo() {

    }
}
