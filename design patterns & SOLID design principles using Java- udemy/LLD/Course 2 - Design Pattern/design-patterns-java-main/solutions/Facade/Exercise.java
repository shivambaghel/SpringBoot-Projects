package Facade;

import java.util.Scanner;

public class Exercise {
    
    public void run() {
        
        Scanner sc = new Scanner(System.in);
        HomeTheaterFacade homeTheater = new HomeTheaterFacade();
        
        int dimmingPercentage = sc.nextInt();

        int volumeLevel = sc.nextInt();
        
        homeTheater.watchMovie(dimmingPercentage, volumeLevel);

        sc.close();
    }
}