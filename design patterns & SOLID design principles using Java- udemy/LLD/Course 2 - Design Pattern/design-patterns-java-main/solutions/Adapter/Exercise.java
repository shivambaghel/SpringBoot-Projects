package Adapter;

import java.util.Scanner;

public class Exercise {
    
    public void run() {
        
        Scanner sc = new Scanner(System.in);

        String legacyTemperature = sc.nextLine();
        String legacyCondition = sc.nextLine();

        // Using the legacy weather service with user input
        WeatherService legacyService = new LegacyWeatherService(legacyTemperature, legacyCondition);
        System.out.println("Legacy Weather Service Data:");
        System.out.println(legacyService.getWeatherData());

        String temperature = sc.nextLine();
        String condition = sc.nextLine();

        // Using the new weather service with user input
        NewWeatherService newService = new NewWeatherService(temperature, condition);
        WeatherService adaptedService = new NewWeatherServiceAdapter(newService);
        System.out.println("New Weather Service Data:");
        System.out.println(adaptedService.getWeatherData());

        sc.close();
    }
}