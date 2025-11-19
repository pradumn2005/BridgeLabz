public class VegetarianMeal implements MealPlan {

    @Override
    public String getPlanName() {
        return "Vegetarian";
    }

    @Override
    public String toString() {
        return "Meal Type: Vegetarian, Focus: Vegetables and Grains";
    }
}
