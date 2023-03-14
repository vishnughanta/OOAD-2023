package main.java.commands;

import main.java.abstracts.Staff;
import main.java.interfaces.Command;

public class ChangeSalespersonCommand implements Command {
    private Staff salesperson;
    public ChangeSalespersonCommand(Staff salesperson) {
        this.salesperson = salesperson;
    }
    @Override
    public void execute() {
        System.out.println("Congratulations! Your salesperson has been successfully changed. The name of the Salesperson assigned to you now is " + salesperson.getName());
    }

    @Override
    public void undo() {

    }
}
