public class KetoMeal implements MealPlan {

    @Override
    public String getPlanName() {
        return "Keto";
    }

    @Override
    public String toString() {
        return "Meal Type: Keto, Focus: Low-Carb, High-Fat";
    }
}
