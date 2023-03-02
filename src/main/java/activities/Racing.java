package activities;

import abstracts.Staff;
import abstracts.Vehicle;
import enums.Condition;
import functions.LinkDriverToVehicle;
import functions.RandomNumberGenerator;
import printer.Printer;
import staff.Driver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Racing extends Activity {
    private List<Vehicle> vehiclesToRace;
    private List<LinkDriverToVehicle> driverToVehicleList;
    private List<Staff> shuffledDrivers;
    List<LinkDriverToVehicle> raceVehicles;

    public Racing() {
        randomGenerator = new RandomNumberGenerator();
        vehiclesToRace = new ArrayList<>();
        driverToVehicleList = new ArrayList<>();
        raceVehicles = new ArrayList<>();
        printer = new Printer();
        System.out.println("Racing..");
        System.out.println();
        shuffleDrivers();
        simulateRace();
        System.out.println();
    }

    private void assignNullAndShuffleRaceVehicles() {
        int nullsToBeAdded = 20 - raceVehicles.size();
        for(int i=0; i<nullsToBeAdded; i++) {
            raceVehicles.add(null);
        }
        Collections.shuffle(raceVehicles);
    }

    private void shuffleDrivers() {
        shuffledDrivers = new ArrayList<>(drivers);
        Collections.shuffle(shuffledDrivers);
    }

    private void simulateRace(){
        assignVehicleType();
        Collections.shuffle(vehiclesToRace);
        assignDriverToVehicles();
        determineRacePositions();
    }

    private void determineRacePositions() {
        firstRacePositions();
        lastRacePositions();
    }

    private void lastRacePositions() {
        for(int i=15; i<20; i++) {
            if(raceVehicles.get(i) != null) {
                assignLostVehicles(raceVehicles.get(i), i+1);
            }
        }
    }

    private void assignLostVehicles(LinkDriverToVehicle linkDriverToVehicle, int position) {
        Driver driver = linkDriverToVehicle.getDriver();
        Vehicle vehicle = linkDriverToVehicle.getVehicle();
        vehicle.setCondition(Condition.BROKEN);
        assignDriverStatus(driver);
        printer.printLastRacePositions(linkDriverToVehicle, position, subscriberObject);
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


    private void firstRacePositions() {
        for(int i=0; i<3; i++) {
            if(raceVehicles.get(i) != null) {
                assignWinVehicles(raceVehicles.get(i), i+1);
            }
        }
    }

    private void assignWinVehicles(LinkDriverToVehicle linkDriverToVehicle, int position) {
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
        printer.printFirstRacePositions(linkDriverToVehicle, position, subscriberObject);
    }

    private void assignVehicleType() {
        int vehicleTypeChance = randomGenerator.generateRandomNumber(0,3);
        if(vehicleTypeChance == 0) {
            vehiclesToRace.addAll(monsterTrucks);
        }
        else if(vehicleTypeChance == 1) {
            vehiclesToRace.addAll(motorcycles);
        }
        else if(vehicleTypeChance == 2) {
            vehiclesToRace.addAll(performanceCars);
        }
        else {
            vehiclesToRace.addAll(pickups);
        }
    }

    private void assignDriverToVehicles() {
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


