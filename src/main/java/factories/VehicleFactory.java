package main.java.factories;

import main.java.abstracts.Vehicle;
import main.java.interfaces.FNCDFactory;
import main.java.staff.Driver;
import main.java.staff.Intern;
import main.java.staff.Mechanic;
import main.java.staff.Salesperson;
import main.java.vehicles.*;

public class VehicleFactory implements FNCDFactory<Vehicle> {

    @Override
    public Vehicle create(int type) {
        if(type == 1) {
            return new Car();
        }
        else if(type == 2) {
            return new Pickup();
        }
        else if(type == 3) {
            return new PerformanceCar();
        }
        else if(type == 4){
            return new ElectricCar();
        }
        else if(type == 5) {
            return new Motorcycle();
        }
        else {
            return new MonsterTruck();
        }
    }
}
