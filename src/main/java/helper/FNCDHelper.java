package main.java.helper;

import main.java.activities.*;
import main.java.interfaces.Subscriber;
import main.java.subscriber.Logger;
import main.java.subscriber.SubscriberObject;
import main.java.subscriber.Tracker;

import java.util.ArrayList;
import java.util.List;

public class FNCDHelper {
    public void simulate() {
        PublisherHelper publisherHelperNorth = new PublisherHelper();
        PublisherHelper publisherHelperSouth = new PublisherHelper();

        Activity activityNorth = new Activity();
        activityNorth.startActivity("North");

        Activity activitySouth = new Activity();
        activitySouth.startActivity("South");

        SubscriberObject subscriberObjectNorth = publisherHelperNorth.getSubscriberObject();
        subscriberObjectNorth.setNameOfFNCD(activityNorth.getNameOfFNCD());

        SubscriberObject subscriberObjectSouth = publisherHelperSouth.getSubscriberObject();
        subscriberObjectSouth.setNameOfFNCD(activitySouth.getNameOfFNCD());

        Subscriber tracker = Tracker.getTracker();
        Subscriber logger = Logger.getLogger();

        activityNorth.setSubscriberObject(publisherHelperNorth.getSubscriberObject());
        activitySouth.setSubscriberObject(publisherHelperSouth.getSubscriberObject());

        List<Activity> listOfActivity = new ArrayList<>();
        listOfActivity.add(activityNorth);
        listOfActivity.add(activitySouth);

        publisherHelperNorth.registerSubscriber(logger);
        publisherHelperSouth.registerSubscriber(logger);
        publisherHelperNorth.registerSubscriber(tracker);
        publisherHelperSouth.registerSubscriber(tracker);

        for(int day=1; day<=31; day++) {
            publisherHelperNorth.getSubscriberObject().setDay(day);
            publisherHelperSouth.getSubscriberObject().setDay(day);
            System.out.println("*************** FNCD Day " + day +" ***************");
            System.out.println();
            Opening openingNorth = new Opening();
            openingNorth.startOpening(activityNorth);

            Opening openingSouth = new Opening();
            openingSouth.startOpening(activitySouth);

            Washing washingNorth = new Washing();
            washingNorth.startWashing(activityNorth);

            Washing washingSouth = new Washing();
            washingSouth.startWashing(activitySouth);

            Repairing repairingNorth = new Repairing();
            repairingNorth.startRepairing(activityNorth);

            Repairing repairingSouth = new Repairing();
            repairingSouth.startRepairing(activitySouth);

            if(day!=31) {
                Selling sellingNorth = new Selling(activityNorth);
                sellingNorth.startSelling(activityNorth, day);

                Selling sellingSouth = new Selling(activitySouth);
                sellingSouth.startSelling(activitySouth, day);
            }
            else {
                CommandLine commandLine = new CommandLine();
                commandLine.startHumanComputerInteraction(listOfActivity);
            }
            if(day % 7 == 3 || day % 7 == 0) {
                Racing racingNorth = new Racing();
                racingNorth.startRacing(activityNorth);

                Racing racingSouth = new Racing();
                racingSouth.startRacing(activitySouth);
            }

            Ending endingNorth = new Ending();
            endingNorth.startEnding(activityNorth);

            Ending endingSouth = new Ending();
            endingSouth.startEnding(activitySouth);

            publisherHelperNorth.notifySubscribers(activityNorth.getSubscriberObject());
            publisherHelperSouth.notifySubscribers(activitySouth.getSubscriberObject());
            publisherHelperNorth.closeDay();
            publisherHelperSouth.closeDay();
            System.out.println();
        }
    }
}
