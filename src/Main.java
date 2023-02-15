import activities.*;

public class Main {
    public static void main(String[] args) {
        Activity activity = new Activity();

        for(int i=0; i<6; i++) {
            Activity opening = new Opening();
            Activity washing = new Washing();
            Activity repairing = new Repairing();
            Activity selling = new Selling(i);
            Activity ending = new Ending();
        }

    }
}