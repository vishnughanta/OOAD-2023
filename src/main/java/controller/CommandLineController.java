package main.java.controller;

import main.java.interfaces.Command;

public class CommandLineController {
    Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void executeCommand() {
        command.execute();
    }
}
