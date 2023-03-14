package main.java.commands;

import main.java.interfaces.Command;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SalespersonTimeCommand implements Command {
    private Date date;
    public SalespersonTimeCommand(Date date) {
        this.date = date;
    }
    public void execute() {
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        System.out.println();
        System.out.println("The current time is: " + formatter.format(date));
        System.out.println();
    }

    @Override
    public void undo() {

    }
}
