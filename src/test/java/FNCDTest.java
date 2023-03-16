package test.java;

import main.java.abstracts.Staff;
import main.java.abstracts.Vehicle;
import main.java.activities.*;
import main.java.enums.Cleanliness;
import main.java.enums.Condition;
import main.java.staff.Intern;
import main.java.vehicles.Car;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class FNCDTest {
    private Activity activity = new Activity();
    private Opening opening = new Opening();
    private Washing washing = new Washing();
    private Repairing repairing = new Repairing();
    private Selling selling  = new Selling(activity);
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
        selling.startSelling(activity, 1);
    }
}
