import activities.*;

public class Main {
    public static void main(String[] args) {
        Activity activity = new Activity();

        for(int day=0; day<30; day++) {
            System.out.println("*************** FNCD Day " + day +" ***************");
            System.out.println();
            if(day % 7 == 0) {
                System.out.println("FNCD is closed for the day. Please come tomorrow!");
                System.out.println();
                continue;
            }
            Activity opening = new Opening();
            Activity washing = new Washing();
            Activity repairing = new Repairing();
            Activity selling = new Selling(day);
            Activity ending = new Ending();
            System.out.println();
        }

    }
}