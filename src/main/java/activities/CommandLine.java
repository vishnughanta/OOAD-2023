package main.java.activities;

import main.java.abstracts.Staff;
import main.java.abstracts.Vehicle;
import main.java.commands.*;
import main.java.controller.CommandLineController;
import main.java.functions.RandomNumberGenerator;
import main.java.interfaces.Command;
import main.java.interfaces.RandomGenerator;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class CommandLine {
    private Scanner scanner;
    private Staff salesperson;
    private Activity activity;
    private CommandLineController commandLineController;
    private RandomGenerator randomGenerator;
    private int indexOfAssignedSalesperson;
    private List<Vehicle> currentInventory;
    private Vehicle vehicle;
    private boolean selectVehicle;

    public CommandLine() {
        currentInventory = new ArrayList<>();
        commandLineController = new CommandLineController();
        scanner = new Scanner(System.in);
        randomGenerator = new RandomNumberGenerator();
        selectVehicle = false;
    }

    public void startHumanComputerInteraction(List<Activity> listOfActivity) {
        selectFNCDLocation(listOfActivity);
        askSalespersonName();
        askSalespersonTime();
        changeSalesperson();
        showCurrentInventory();
        showDetailOfSelectedInventory();

    }

    private void showDetailOfSelectedInventory() {
        System.out.println("Do you want the detail of any vehicle in the current inventory? (Y/N)");
        String inputByUser = scanner.next();
        int input = -1;
        if (inputByUser.toLowerCase().equals("y")) {
            selectVehicle = true;
            System.out.println("Please enter the index of the vehicle");
            input = scanInputByUser(input, currentInventory.size());
            vehicle = currentInventory.get(input-1);
            Command detailOfInventory = new DetailInventoryCommand(vehicle);
            commandLineController.setCommand(detailOfInventory);
            commandLineController.executeCommand();
        }

    }

    private void showCurrentInventory() {
        addVehicles();
        System.out.println("Do you want to see the current inventory in the FNCD? (Y/N)");
        String inputByUser = scanner.next();
        if (inputByUser.toLowerCase().equals("y")) {
            Command askCurrentInventory = new CurrentInventoryCommand(currentInventory);
            commandLineController.setCommand(askCurrentInventory);
            commandLineController.executeCommand();
        }
    }

    private void addVehicles() {
        currentInventory.addAll(activity.getCars());
        currentInventory.addAll(activity.getPickups());
        currentInventory.addAll(activity.getPerformanceCars());
        currentInventory.addAll(activity.getElectricCars());
        currentInventory.addAll(activity.getMonsterTrucks());
        currentInventory.addAll(activity.getMotorcycles());
        currentInventory.addAll(activity.getCoupes());
        currentInventory.addAll(activity.getMinivans());
        currentInventory.addAll(activity.getSuvs());
    }

    private void changeSalesperson() {
        List<Staff> salespersonList = activity.getSalespersons();
        System.out.println("Do you want to change the salesperson? (Y/N)");
        String inputByUser = scanner.next();
        if(inputByUser.toLowerCase().equals("y")) {
            int nextAssignedSalesperson = randomGenerator.generateRandomNumber(0, salespersonList.size()-1);
            while(nextAssignedSalesperson == indexOfAssignedSalesperson) {
                nextAssignedSalesperson = randomGenerator.generateRandomNumber(0, salespersonList.size()-1);
            }
            indexOfAssignedSalesperson = nextAssignedSalesperson;
            salesperson = salespersonList.get(indexOfAssignedSalesperson);
            Command changeSalesperson = new ChangeSalespersonCommand(salesperson);
            commandLineController.setCommand(changeSalesperson);
            commandLineController.executeCommand();
        }
    }

    private void askSalespersonTime() {
        System.out.println("Do you want to ask the time to the salesperson? (Y/N)");
        String inputByUser = scanner.next();
        if(inputByUser.toLowerCase().equals("y")) {
            Date date = new Date();

            Command salespersonTimeCommand = new SalespersonTimeCommand(date);
            commandLineController.setCommand(salespersonTimeCommand);
            commandLineController.executeCommand();
        }
    }

    private void askSalespersonName() {
        System.out.println("Congratulations! You have been assigned a salesperson.");
        System.out.println("Do you want to know the Salespersons' name? (Y/N)");
        String inputByUser = scanner.next();
        if(inputByUser.toLowerCase().equals("y")) {
            List<Staff> salespersonsList = activity.getSalespersons();
            indexOfAssignedSalesperson = randomGenerator.generateRandomNumber(0, salespersonsList.size()-1);
            salesperson = salespersonsList.get(indexOfAssignedSalesperson);
            Command salespersonNameCommand = new SalespersonNameCommand(salesperson);
            commandLineController.setCommand(salespersonNameCommand);
            commandLineController.executeCommand();
        }
    }

    private void selectFNCDLocation(List<Activity> listOfActivity) {
        System.out.println("It's Day 31. Welcome to the Human Computer Interaction!");
        System.out.println("Please select the location of FNCD that you are interested in");
        int indexOfFNCD = 1;
        int inputByUser = -1;
        for(Activity activity : listOfActivity) {
            System.out.println(indexOfFNCD + ": " + activity.getNameOfFNCD());
            indexOfFNCD++;
        }
        inputByUser = scanInputByUser(inputByUser, listOfActivity.size());
        activity = listOfActivity.get(inputByUser - 1);
        Command selectFNCDLocationCommand = new SelectFNCDLocationCommand(activity);
        commandLineController.setCommand(selectFNCDLocationCommand);
        commandLineController.executeCommand();
    }

    private int scanInputByUser(int userInput, int size) {
        while(userInput <= 0 || userInput > size) {
            try {
                System.out.println();
                userInput = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Select a valid choice");
            }
        }
        return userInput;
    }
}
