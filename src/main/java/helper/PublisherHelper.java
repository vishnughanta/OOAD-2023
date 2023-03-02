package helper;

import interfaces.Publisher;
import interfaces.Subscriber;
import subscriber.SubscriberObject;

import java.util.ArrayList;
import java.util.List;

public class PublisherHelper implements Publisher {
    private List<Subscriber> subscriberList;
    private SubscriberObject subscriberObject;

    public PublisherHelper() {
        subscriberObject = new SubscriberObject();
        subscriberList = new ArrayList<>();
    }
    @Override
    public void registerSubscriber(Subscriber subscriber) {
        subscriberList.add(subscriber);
    }

    @Override
    public void unregisterSubscriber(Subscriber subscriber) {
        subscriberList.remove(subscriber);
    }

    @Override
    public void notifySubscribers(SubscriberObject subscriberObject) {
        for(Subscriber subscriber : subscriberList) {
            subscriber.update(subscriberObject);
        }
    }

    public List<Subscriber> getSubscriberList() {
        return subscriberList;
    }

    public void setSubscriberList(List<Subscriber> subscriberList) {
        this.subscriberList = subscriberList;
    }

    public SubscriberObject getSubscriberObject() {
        return subscriberObject;
    }

    public void setSubscriberObject(SubscriberObject subscriberObject) {
        this.subscriberObject = subscriberObject;
    }

    public void closeDay() {
        subscriberObject.setLogList(new ArrayList<>());
    }
}
