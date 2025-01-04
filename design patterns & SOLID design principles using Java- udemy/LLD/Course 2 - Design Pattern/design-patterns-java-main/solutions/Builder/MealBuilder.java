package Builder;

public class MealBuilder {
    
    public String mainDish;
    public String sideDish;
    public String drink;
    public String dessert = "Default Dessert";
    public String appetizer = "Default Appetizer";

    public MealBuilder(String mainDish, String sideDish, String drink) {
        this.mainDish = mainDish;
        this.sideDish = sideDish;
        this.drink = drink;
    }

    public MealBuilder setDessert(String dessert) {
        this.dessert = dessert;
        return this;
    }

    public MealBuilder setAppetizer(String appetizer) {
        this.appetizer = appetizer;
        return this;
    }

    public Meal build() {
        return Meal.getInstance(this);
    }
}