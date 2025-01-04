package Iterator;

import java.util.Scanner;

public class Exercise {

    public void run() {
        
        Scanner sc = new Scanner(System.in);
        NotificationManager notificationManager = new NotificationManager();

        // Add Notifications
        for(int i=0;i < 2;i++) {
            String emailNotification = sc.nextLine();
            String smsNotification = sc.nextLine();
            String pushNotification = sc.nextLine();
            
            notificationManager.addEmailNotification(emailNotification);
            notificationManager.addSMSNotification(smsNotification);
            notificationManager.addPushNotification(pushNotification);
        }

        // Print all notifications
        notificationManager.printAllNotifications();

        sc.close();
    }
}