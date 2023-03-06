package main.java.interfaces;

import main.java.subscriber.SubscriberObject;

public interface Publisher {
    void registerSubscriber(Subscriber subscriber);
    void unregisterSubscriber(Subscriber subscriber);
    void notifySubscribers(SubscriberObject subscriberObject);
}
