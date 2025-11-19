public class VeganMeal implements MealPlan {

    @Override
    public String getPlanName() {
        return "Vegan";
    }

    @Override
    public String toString() {
        return "Meal Type: Vegan, Focus: Plant-Based Only";
    }
}
