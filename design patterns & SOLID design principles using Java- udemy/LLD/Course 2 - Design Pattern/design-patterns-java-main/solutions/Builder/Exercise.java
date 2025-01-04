package Builder;

import java.util.Scanner;

public class Exercise {

    public void run() {
        
        Scanner sc = new Scanner(System.in);
        
        // Get full meal components from user
        String fullMainDish = sc.nextLine();
        
        String fullSideDish = sc.nextLine();
        
        String fullDrink = sc.nextLine();
        
        String fullDessert = sc.nextLine();
        
        String fullAppetizer = sc.nextLine();
        
        Meal fullMeal = new MealBuilder(fullMainDish, fullSideDish, fullDrink)
                                        .setDessert(fullDessert)
                                        .setAppetizer(fullAppetizer)
                                        .build();
                            
        System.out.println("Full Meal Summary:");
        fullMeal.printMealSummary();


        // Get simple meal components from user
        String simpleMainDish = sc.nextLine();

        String simpleSideDish = sc.nextLine();
        
        String simpleDrink = sc.nextLine();

        Meal simpleMeal = new MealBuilder(simpleMainDish, simpleSideDish, simpleDrink).build();
                            
        System.out.println("Simple Meal Summary:");
        simpleMeal.printMealSummary();

        sc.close();
    }
}