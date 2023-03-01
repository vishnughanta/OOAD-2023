package interfaces;

import subscriber.SubscriberObject;

public interface Publisher {
    void registerSubscriber(Subscriber subscriber);
    void unregisterSubscriber(Subscriber subscriber);
    void notifySubscribers(SubscriberObject subscriberObject);
}
