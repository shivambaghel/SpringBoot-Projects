package Decorator;

import java.util.Scanner;

public class Exercise {

    public void run(){
        
        Scanner sc = new Scanner(System.in);

        Coffee coffee = new BasicCoffee();

        boolean addMoreIngredients = true;

        while (addMoreIngredients) {

            String choices = sc.nextLine();
            String[] ingredients = choices.split(" ");

            for (String choice : ingredients) {
                
                switch (choice) {
                    case "1":
                        coffee = new Milk(coffee);
                        break;
                    case "2":
                        coffee = new Sugar(coffee);
                        break;
                    case "3":
                        coffee = new WhippedCream(coffee);
                        break;
                    case "4":
                        addMoreIngredients = false;
                        break;
                    default:
                        System.out.println("Invalid choice: " + choice);
                        break;
                }
            }

            if (!addMoreIngredients) {
                break;
            }
        }

        System.out.println("Final Coffee Description: " + coffee.getDescription());
        System.out.println("Total Cost: $" + coffee.getCost());

        sc.close();
    }
}
