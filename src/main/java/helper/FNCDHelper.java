package main.java.helper;

import main.java.activities.*;
import main.java.interfaces.Subscriber;
import main.java.subscriber.Logger;
import main.java.subscriber.Tracker;

public class FNCDHelper {
    public void simulate() {

        PublisherHelper publisherHelper = new PublisherHelper();
        Subscriber tracker = new Tracker();
        Activity activity = new Activity();
        Activity.setSubscriberObject(publisherHelper.getSubscriberObject());
        publisherHelper.registerSubscriber(tracker);

        for(int day=1; day<=30; day++) {
            Subscriber logger = new Logger();
            publisherHelper.registerSubscriber(logger);
            publisherHelper.getSubscriberObject().setDay(day);
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
            publisherHelper.notifySubscribers(Activity.getSubscriberObject());
            publisherHelper.unregisterSubscriber(logger);
            publisherHelper.closeDay();
            System.out.println();
        }
    }
}
