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

    public CommandLine() {
        currentInventory = new ArrayList<>();
        commandLineController = new CommandLineController();
        scanner = new Scanner(System.in);
        randomGenerator = new RandomNumberGenerator();
    }

    public void startHumanComputerInteraction(List<Activity> listOfActivity) {
        System.out.println("It's Day 31. Welcome to the Human Computer Interaction!");
        System.out.println("Please select the location of FNCD that you are interested in");
        int indexOfFNCD = 1;
        for(Activity activity : listOfActivity) {
            System.out.println(indexOfFNCD + ": " + activity.getNameOfFNCD());
            indexOfFNCD++;
        }
        selectFNCDLocation(listOfActivity);
        addVehicles();
        String input = "";

        while(true) {
            System.out.println();
            displayOptions();
            System.out.println();
            input = scanner.next();
            if(input.equals("a")) {
                selectFNCDLocation(listOfActivity);
            }
            else if(input.equals("b")) {
                askSalespersonName();
            }
            else if(input.equals("c")) {
                askSalespersonTime();
            }
            else if(input.equals("d")) {
                changeSalesperson();
            }
            else if(input.equals("e")) {
                showCurrentInventory();
            }
            else if(input.equals("f")) {
                showDetailOfSelectedInventory();
            }
            else if(input.equals("g")) {
                buyCarFromInventory();
            }
            else if(input.equals("q")) {
                break;
            }
        }
    }

    private void displayOptions() {
        System.out.println("a: Change the location of FNCD");
        System.out.println("b: Ask the name of the Salesperson assigned");
        System.out.println("c: Ask the time to the Salesperson");
        System.out.println("d: Change the salesperson assigned");
        System.out.println("e: See the current inventory");
        System.out.println("f: Detail of a selected vehicle from inventory");
        System.out.println("g: Buy a car from inventory");
        System.out.println("q: Exit the Human Computer Interaction");
    }

    private void buyCarFromInventory() {
        Command askCurrentInventory = new CurrentInventoryCommand(currentInventory);
        commandLineController.setCommand(askCurrentInventory);
        commandLineController.executeCommand();

        int input = -1;
        System.out.println("Please enter the index of the vehicle");
        input = scanInputByUser(input, currentInventory.size());
        vehicle = currentInventory.get(input-1);
        Command buyVehicleFromInventory = new BuyInventoryCommand(salesperson, activity, vehicle);
        commandLineController.setCommand(buyVehicleFromInventory);
        commandLineController.executeCommand();
    }

    private void showDetailOfSelectedInventory() {
        Command askCurrentInventory = new CurrentInventoryCommand(currentInventory);
        commandLineController.setCommand(askCurrentInventory);
        commandLineController.executeCommand();

        int input = -1;
        System.out.println("Please enter the index of the vehicle");
        input = scanInputByUser(input, currentInventory.size());
        vehicle = currentInventory.get(input-1);
        Command detailOfInventory = new DetailInventoryCommand(vehicle);
        commandLineController.setCommand(detailOfInventory);
        commandLineController.executeCommand();
    }

    private void showCurrentInventory() {
        Command askCurrentInventory = new CurrentInventoryCommand(currentInventory);
        commandLineController.setCommand(askCurrentInventory);
        commandLineController.executeCommand();

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

    private void askSalespersonTime() {
        Date date = new Date();

        Command salespersonTimeCommand = new SalespersonTimeCommand(date);
        commandLineController.setCommand(salespersonTimeCommand);
        commandLineController.executeCommand();
    }

    private void askSalespersonName() {
        Command salespersonNameCommand = new SalespersonNameCommand(salesperson);
        commandLineController.setCommand(salespersonNameCommand);
        commandLineController.executeCommand();
    }

    private void selectFNCDLocation(List<Activity> listOfActivity) {
        int inputByUser = -1;
        inputByUser = scanInputByUser(inputByUser, listOfActivity.size());
        activity = listOfActivity.get(inputByUser - 1);

        List<Staff> salespersonList = activity.getSalespersons();
        indexOfAssignedSalesperson = randomGenerator.generateRandomNumber(0, salespersonList.size()-1);
        salesperson = salespersonList.get(indexOfAssignedSalesperson);

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
