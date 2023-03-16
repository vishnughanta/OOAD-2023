package main.java.subscriber;

import main.java.interfaces.Subscriber;

public class Tracker implements Subscriber {
    private static Tracker tracker;
    private Tracker() {}
    public static Tracker getTracker() {
        if(tracker == null) {
            tracker = new Tracker();
        }
        return tracker;
    }
    public void update(SubscriberObject subscriberObject) {
        printAmount(subscriberObject);
    }

    private void printAmount(SubscriberObject subObj) {
        System.out.println("Tracker Results...");
        System.out.println();
        System.out.println("Tracker in FNCD " + subObj.getNameOfFNCD() + ": Day" +" "+ subObj.getDay());
        System.out.printf("Total money earned by all staff: $%.02f", subObj.getTotalMoneyStaff());
        System.out.println();
        System.out.printf("Total money earned by the FNCD: $%.02f", subObj.getTotalMoneyFNCD());
        System.out.println();
        System.out.println();
    }
}
