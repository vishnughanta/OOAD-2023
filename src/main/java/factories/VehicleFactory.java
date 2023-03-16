package main.java.factories;

import main.java.abstracts.Vehicle;
import main.java.activities.Activity;
import main.java.interfaces.FNCDFactory;

import main.java.vehicles.*;

public class VehicleFactory implements FNCDFactory<Vehicle> {

    @Override
    public Vehicle create(int type, Activity activity) {
        if(type == 1) {
            return new Car(activity);
        }
        else if(type == 2) {
            return new Pickup(activity);
        }
        else if(type == 3) {
            return new PerformanceCar(activity);
        }
        else if(type == 4){
            return new ElectricCar(activity);
        }
        else if(type == 5) {
            return new Motorcycle(activity);
        }
        else if(type == 6){
            return new MonsterTruck(activity);
        }
        else if(type == 7) {
            return new Coupe(activity);
        }
        else if(type == 8) {
            return new Minivan(activity);
        }
        else {
            return new SportUtilityVehicle(activity);
        }
    }
}
