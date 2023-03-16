package test.java;

import main.java.abstracts.Staff;
import main.java.abstracts.Vehicle;
import main.java.activities.*;
import main.java.commands.SalespersonNameCommand;
import main.java.controller.CommandLineController;
import main.java.enums.Cleanliness;
import main.java.enums.Condition;
import main.java.factories.StaffFactory;
import main.java.factories.VehicleFactory;
import main.java.functions.Detailed;
import main.java.functions.RandomNumberGenerator;
import main.java.interfaces.Command;
import main.java.interfaces.FNCDFactory;
import main.java.interfaces.RandomGenerator;
import main.java.interfaces.WashingMethod;
import main.java.staff.Intern;
import main.java.staff.Salesperson;
import main.java.subscriber.Logger;
import main.java.vehicles.Car;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class FNCDTest {
    private Activity activity = new Activity();
    private Opening opening = new Opening();
    private Washing washing = new Washing();
    private Repairing repairing = new Repairing();
    //private Selling selling  = new Selling(activity);
    public FNCDTest() {
        activity.startActivity("Temp");
    }
    @Test
    void budgetTest() {
        Assertions.assertEquals(activity.getBudget(), 500000);
    }

    @Test
    void staffObjectTest() {
        Staff intern = new Intern(activity);
        Assertions.assertEquals(intern.getSalary(), 100);
    }

    @Test
    void vehicleObjectTest() {
        Vehicle car = new Car(activity);
        Assertions.assertTrue(car.getCostPrice() >= 5000 && car.getCostPrice() <= 20000);
    }

    @Test
    void openingActivityStaffTest() {
        opening.startOpening(activity);
        int staffSize = activity.getInterns().size() + activity.getSalespersons().size() + activity.getMechanics().size() + activity.getDrivers().size();
        Assertions.assertEquals(staffSize, 12);
    }

    @Test
    void openingActivityVehicleTest() {
        opening.startOpening(activity);
        int vehicleSize = activity.getCars().size() + activity.getPickups().size() + activity.getPerformanceCars().size() + activity.getElectricCars().size() + activity.getMotorcycles().size() + activity.getMonsterTrucks().size() + activity.getCoupes().size() + activity.getMinivans().size() + activity.getSuvs().size();
        Assertions.assertEquals(vehicleSize, 54);
    }

    @Test
    void washingActivityTest() {
        opening.startOpening(activity);
        washing.startWashing(activity);
        List<Vehicle> cleanVehicles = washing.getCleanVehicles();
        List<Vehicle> dirtyVehicles = washing.getDirtyVehicles();

        int sparklingVehiclesCount = 0;

        for (Vehicle vehicle : cleanVehicles) {
            if (vehicle.getCleanliness() == Cleanliness.SPARKLING) sparklingVehiclesCount++;
        }

        for (Vehicle vehicle : dirtyVehicles) {
            if (vehicle.getCleanliness() == Cleanliness.SPARKLING) sparklingVehiclesCount++;
        }
        Assertions.assertEquals(sparklingVehiclesCount, 0);
    }
    @Test
    void repairingActivityTest() {
        opening.startOpening(activity);
        repairing.startRepairing(activity);
        List<Vehicle> repairedVehicles = repairing.getVehiclesToBeRepaired();

        int newVehiclesCount = 0;

        for(Vehicle vehicle : repairedVehicles) {
            if(vehicle.getCondition() == Condition.NEW) newVehiclesCount++;
        }
        Assertions.assertEquals(newVehiclesCount, 0);
    }

    @Test
    void sellingActivityTest() {
        opening.startOpening(activity);
        Selling selling = new Selling(activity);
        selling.startSelling(activity, 1);
        Assertions.assertTrue(selling.getNumberOfBuyers() >=0 && selling.getNumberOfBuyers() <=5);

        selling.startSelling(activity, 5);
        Assertions.assertTrue(selling.getNumberOfBuyers() >=2 && selling.getNumberOfBuyers() <=8);
    }

    @Test
    void racingActivityTest() {
        opening.startOpening(activity);
        Racing racing = new Racing();
        racing.startRacing(activity);
        Assertions.assertEquals(20, racing.getRaceVehicles().size());
    }

    @Test
    void randomGeneratorNumTest() {
        RandomGenerator randomGenerator = new RandomNumberGenerator();
        int randomNum = randomGenerator.generateRandomNumber(1, 60);
        Assertions.assertTrue(randomNum >= 1 && randomNum <= 60);
    }

    @Test
    void washingMethodTest() {
        Vehicle car = new Car(activity);
        Condition carCondition = car.getCondition();
        WashingMethod washingMethod = new Detailed();
        washingMethod.wash(car);
        Assertions.assertEquals(carCondition, car.getCondition());
    }

    @Test
    void factoryPatternStaffTest() {
        FNCDFactory<Staff> fncdFactory = new StaffFactory();
        Staff intern = fncdFactory.create(1, activity);
        Assertions.assertEquals(intern.getSalary(), 100);

    }

    @Test
    void factoryPatternVehicleTest() {
        FNCDFactory<Vehicle> fncdFactory = new VehicleFactory();
        Vehicle car = fncdFactory.create(1, activity);
        Assertions.assertTrue(car.getCostPrice() >= 5000 && car.getCostPrice() <= 20000);
    }

    @Test
    void singletonPatternTest() {
        Logger logger = Logger.getLogger();
        Assertions.assertEquals(logger, Logger.getLogger());
    }

    @Test
    void commandPatternTest() {
        CommandLineController commandLineController = new CommandLineController();
        Staff salesperson = new Salesperson(activity);
        String salespersonName = salesperson.getName();
        Command command = new SalespersonNameCommand(salesperson);
        commandLineController.setCommand(command);
        Assertions.assertEquals(salespersonName, salesperson.getName());
    }
}
