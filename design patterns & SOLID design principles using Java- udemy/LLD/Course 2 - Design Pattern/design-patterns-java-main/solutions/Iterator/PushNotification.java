package Iterator;

import java.util.LinkedHashSet;
import java.util.Iterator;
import java.util.Set;

public class PushNotification implements NotificationCollection {
    
    private Set<Notification> pushNotifications;

    public PushNotification() {
        pushNotifications = new LinkedHashSet<>();
    }

    public void addNotification(String message) {
        pushNotifications.add(new Notification(message));
    }

    @Override
    public Iterator<Notification> createIterator() {
        return new PushNotificationIterator(pushNotifications);
    }

    private class PushNotificationIterator implements Iterator<Notification> {
        private Iterator<Notification> iterator;

        public PushNotificationIterator(Set<Notification> notifications) {
            this.iterator = notifications.iterator();
        }

        @Override
        public boolean hasNext() {
            return iterator.hasNext();
        }

        @Override
        public Notification next() {
            return iterator.next();
        }
    }
}