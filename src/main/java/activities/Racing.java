package main.java.activities;

import main.java.abstracts.Staff;
import main.java.abstracts.Vehicle;
import main.java.enums.Condition;
import main.java.functions.LinkDriverToVehicle;
import main.java.functions.RandomNumberGenerator;
import main.java.interfaces.RandomGenerator;
import main.java.printer.Printer;
import main.java.staff.Driver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Racing {
    private List<Vehicle> vehiclesToRace;
    private List<LinkDriverToVehicle> driverToVehicleList;
    private List<Staff> shuffledDrivers;
    List<LinkDriverToVehicle> raceVehicles;
    private RandomGenerator randomGenerator;
    private Printer printer;

    public Racing() {
    }

    public void startRacing(Activity activity) {
        randomGenerator = new RandomNumberGenerator();
        vehiclesToRace = new ArrayList<>();
        driverToVehicleList = new ArrayList<>();
        raceVehicles = new ArrayList<>();
        printer = new Printer();
        System.out.println("Racing..");
        System.out.println();
        shuffleDrivers(activity);
        simulateRace(activity);
        System.out.println();

    }

    private void assignNullAndShuffleRaceVehicles() {
        int nullsToBeAdded = 20 - raceVehicles.size();
        for(int i=0; i<nullsToBeAdded; i++) {
            raceVehicles.add(null);
        }
        Collections.shuffle(raceVehicles);
    }

    private void shuffleDrivers(Activity activity) {
        shuffledDrivers = new ArrayList<>(activity.getDrivers());
        Collections.shuffle(shuffledDrivers);
    }

    private void simulateRace(Activity activity){
        assignVehicleType(activity);
        Collections.shuffle(vehiclesToRace);
        assignDriverToVehicles(activity);
        determineRacePositions(activity);
    }

    private void determineRacePositions(Activity activity) {
        firstRacePositions(activity);
        lastRacePositions(activity);
    }

    private void lastRacePositions(Activity activity) {
        for(int i=15; i<20; i++) {
            if(raceVehicles.get(i) != null) {
                assignLostVehicles(raceVehicles.get(i), i+1, activity);
            }
        }
    }

    private void assignLostVehicles(LinkDriverToVehicle linkDriverToVehicle, int position, Activity activity) {
        Driver driver = linkDriverToVehicle.getDriver();
        Vehicle vehicle = linkDriverToVehicle.getVehicle();
        vehicle.setCondition(Condition.BROKEN);
        assignDriverStatus(driver);
        printer.printLastRacePositions(linkDriverToVehicle, position, activity.getSubscriberObject());
    }

    private void assignDriverStatus(Driver driver) {
        int injuredChance = randomGenerator.generateRandomNumber(0,100);
        if(injuredChance >=0 && injuredChance<30) {
            assignDriverInjured(driver);
        }
    }

    private void assignDriverInjured(Driver driver) {
        driver.setInjured(true);
    }


    private void firstRacePositions(Activity activity) {
        for(int i=0; i<3; i++) {
            if(raceVehicles.get(i) != null) {
                assignWinVehicles(raceVehicles.get(i), i+1, activity);
            }
        }
    }

    private void assignWinVehicles(LinkDriverToVehicle linkDriverToVehicle, int position, Activity activity) {
        Driver driver = linkDriverToVehicle.getDriver();
        Vehicle vehicle = linkDriverToVehicle.getVehicle();
        int racesWonByVehicle = vehicle.getRacesWon();
        vehicle.setRacesWon(racesWonByVehicle + 1);

        if(vehicle.getRacesWon() > 0) {
            double initialSalesPrice = vehicle.getSalePrice();
            vehicle.setSalePrice(1.1 * initialSalesPrice);
        }

        int racesWonByDriver = driver.getRacesWon();
        driver.setRacesWon(racesWonByDriver + 1);
        printer.printFirstRacePositions(linkDriverToVehicle, position, activity.getSubscriberObject());
    }

    private void assignVehicleType(Activity activity) {
        int vehicleTypeChance = randomGenerator.generateRandomNumber(0,3);
        if(vehicleTypeChance == 0) {
            vehiclesToRace.addAll(activity.getMonsterTrucks());
        }
        else if(vehicleTypeChance == 1) {
            vehiclesToRace.addAll(activity.getMotorcycles());
        }
        else if(vehicleTypeChance == 2) {
            vehiclesToRace.addAll(activity.getPerformanceCars());
        }
        else {
            vehiclesToRace.addAll(activity.getPickups());
        }
    }

    private void assignDriverToVehicles(Activity activity) {
        int countOfVehicles = 0;

        while(countOfVehicles < 3 && !vehiclesToRace.isEmpty() && vehiclesToRace.size() > countOfVehicles) {
            Driver driver = (Driver) shuffledDrivers.get(countOfVehicles);
            driver.setWorked(true);
            Vehicle vehicle = vehiclesToRace.get(countOfVehicles);
            driverToVehicleList.add(new LinkDriverToVehicle(driver, vehicle));
            countOfVehicles++;
        }

        raceVehicles.addAll(driverToVehicleList);
        assignNullAndShuffleRaceVehicles();
    }
}


