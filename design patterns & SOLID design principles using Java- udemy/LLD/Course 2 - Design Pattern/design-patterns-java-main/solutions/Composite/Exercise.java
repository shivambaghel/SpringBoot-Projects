package Composite;

import java.util.Scanner;

public class Exercise {
    
    public void run() {
        
        Scanner sc = new Scanner(System.in);
    
        String appetizersSectionName = sc.nextLine();
        String mainCoursesSectionName = sc.nextLine();
        String dessertsSectionName = sc.nextLine();
        String seaFoodSectionName = sc.nextLine();
    
        // Create menu sections with user-defined names
        MenuSection appetizers = new MenuSection(appetizersSectionName);
        MenuSection mainCourses = new MenuSection(mainCoursesSectionName);
        MenuSection desserts = new MenuSection(dessertsSectionName);
        MenuSection seafood = new MenuSection(seaFoodSectionName);
    
        // Get user input for appetizers
        for (int i = 0; i < 2; i++) {
            String name = sc.nextLine();
            String description = sc.nextLine();
            double price = sc.nextDouble();
            sc.nextLine();
            MenuItem appetizer = new MenuItem(name, description, price);
            appetizers.add(appetizer);
        }
    
        // Get user input for main courses
        for (int i = 0; i < 2; i++) {
            String name = sc.nextLine();
            String description = sc.nextLine();
            double price = sc.nextDouble();
            sc.nextLine();
            MenuItem mainCourse = new MenuItem(name, description, price);
            mainCourses.add(mainCourse);
        }
    
        // Get user input for desserts
        for (int i = 0; i < 2; i++) {
            String name = sc.nextLine();
            String description = sc.nextLine();
            double price = sc.nextDouble();
            sc.nextLine();
            MenuItem dessert = new MenuItem(name, description, price);
            desserts.add(dessert);
        }
        
        mainCourses.add(seafood);
    
        // Create the full menu section
        MenuSection fullMenu = new MenuSection("Restaurant Menu");
        fullMenu.add(appetizers);
        fullMenu.add(mainCourses);
        fullMenu.add(desserts);
    
        // Print the entire menu
        System.out.println("\nFull Menu:");
        fullMenu.print();

        sc.close();
    }
}