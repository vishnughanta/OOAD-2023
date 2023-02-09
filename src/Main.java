import activities.*;

public class Main {
    public static void main(String[] args) {
        Activity activity = new Activity();
        Activity opening = new Opening();
        Activity washing = new Washing();
        Activity repairing = new Repairing();
        Selling selling = new Selling();
        selling.sellVehicles(10);

    }
}