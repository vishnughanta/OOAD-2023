package main.java.commands;

import main.java.activities.Activity;
import main.java.interfaces.Command;

public class SelectFNCDLocationCommand implements Command {
    Activity activity;
    public SelectFNCDLocationCommand(Activity activity) {
        this.activity = activity;
    }
    @Override
    public void execute() {
        System.out.println("You have selected " + activity.getNameOfFNCD() + " FNCD.");
    }

    @Override
    public void undo() {

    }
}
