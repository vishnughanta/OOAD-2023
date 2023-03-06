package main.java.subscriber;

import main.java.interfaces.Subscriber;

public class Tracker implements Subscriber {
    public void update(SubscriberObject subscriberObject) {
        printAmount(subscriberObject);
    }

    private void printAmount(SubscriberObject subObj) {
        System.out.println("Tracker Results...");
        System.out.println();
        System.out.println("Tracker: Day" +" "+ subObj.getDay());
        System.out.printf("Total money earned by all staff: $%.02f", subObj.getTotalMoneyStaff());
        System.out.println();
        System.out.printf("Total money earned by the FNCD: $%.02f", subObj.getTotalMoneyFNCD());
        System.out.println();
        System.out.println();
    }
}
