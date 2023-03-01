package helper;

import activities.*;

public class FNCDHelper {
    public void simulate() {
        Activity activity = new Activity();

        for(int day=0; day<30; day++) {
            System.out.println("*************** FNCD Day " + day +" ***************");
            System.out.println();
            Activity opening = new Opening();
            Activity washing = new Washing();
            Activity repairing = new Repairing();
            Activity selling = new Selling(day);
            if(day%7==3 || day%7==0) {
                Activity racing = new Racing();
            }
            Activity ending = new Ending();
            System.out.println();
        }
    }
}
