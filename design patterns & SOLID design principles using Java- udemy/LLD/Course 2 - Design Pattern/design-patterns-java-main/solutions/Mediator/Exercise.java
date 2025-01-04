package Mediator;

import java.util.Scanner;

public class Exercise {

    public void run() {
        
        Scanner sc = new Scanner(System.in);
        
        // Create the control tower (mediator)
        ControlTower controlTower = new ControlTower();
        
        String airplaneId1 = sc.nextLine();
        String airplaneId2 = sc.nextLine();
        String airplaneId3 = sc.nextLine();
        String airplaneId4 = sc.nextLine();

        // Create airplanes with user input
        Airplane airplane1 = new Airplane(airplaneId1);
        Airplane airplane2 = new Airplane(airplaneId2);
        Airplane airplane3 = new Airplane(airplaneId3);
        Airplane airplane4 = new Airplane(airplaneId4);

        // Register airplanes with the control tower
        controlTower.registerAirplane(airplane1);
        controlTower.registerAirplane(airplane2);
        controlTower.registerAirplane(airplane3);
        controlTower.registerAirplane(airplane4);

        // Airplanes request takeoff and landing
        airplane1.requestTakeoff();
        airplane2.requestTakeoff();
        airplane3.requestTakeoff();
        airplane4.requestTakeoff();
        
        // Manually simulate completion of the next requests
        controlTower.completeTakeoff(airplane1);
        controlTower.completeTakeoff(airplane2);

        airplane3.requestTakeoff();
        airplane4.requestTakeoff();
        
        // Manually simulate completion of the next requests
        controlTower.completeTakeoff(airplane3);
        controlTower.completeTakeoff(airplane4);

        // Additional requests to demonstrate functionality
        airplane1.requestLanding();
        airplane2.requestLanding();
        
        // Manually simulate completion of the next requests
        controlTower.completeLanding(airplane1);
        controlTower.completeLanding(airplane2);
        
        airplane3.requestLanding();
        airplane4.requestLanding();
        
        // Manually simulate completion of the next requests
        controlTower.completeLanding(airplane3);
        controlTower.completeLanding(airplane4);

        sc.close();
    }
}