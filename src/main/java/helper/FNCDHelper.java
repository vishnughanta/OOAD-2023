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
        activity.startActivity("North");
        activity.setSubscriberObject(publisherHelper.getSubscriberObject());
        publisherHelper.registerSubscriber(tracker);

        for(int day=1; day<=30; day++) {
            Subscriber logger = new Logger();
            publisherHelper.registerSubscriber(logger);
            publisherHelper.getSubscriberObject().setDay(day);
            System.out.println("*************** FNCD Day " + day +" ***************");
            System.out.println();
            Opening opening = new Opening();
            opening.startOpening(activity);
            Washing washing = new Washing();
            washing.startWashing(activity);
            Repairing repairing = new Repairing();
            repairing.startRepairing(activity);
            Racing racing = new Racing();
            racing.startRacing(activity);
            Selling selling = new Selling();
            selling.startSelling(activity, day);
            Ending ending = new Ending();
            ending.startEnding(activity);
//            Activity selling = new Selling(day);
//            if(day%7==3 || day%7==0) {
//                Activity racing = new Racing();
//            }
//            Activity ending = new Ending();
//            publisherHelper.notifySubscribers(Activity.getSubscriberObject());
//            publisherHelper.unregisterSubscriber(logger);
//            publisherHelper.closeDay();
            System.out.println();
        }
    }
}
