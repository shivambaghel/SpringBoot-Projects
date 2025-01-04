package Builder;

public class Meal {
    
    private String mainDish;
    private String sideDish;
    private String drink;
    private String dessert;
    private String appetizer;

    private Meal(MealBuilder builder) {
        this.mainDish = builder.mainDish;
        this.sideDish = builder.sideDish;
        this.drink = builder.drink;
        this.dessert = builder.dessert;
        this.appetizer = builder.appetizer;
    }
    
    public static synchronized Meal getInstance(MealBuilder builder) {
        return new Meal(builder);
    }

    public void printMealSummary() {
        System.out.println("Main Dish: " + mainDish);
        System.out.println("Side Dish: " + sideDish);
        System.out.println("Drink: " + drink);
        System.out.println("Dessert: " + dessert);
        System.out.println("Appetizer: " + appetizer);
    }
}