public class Meal<T extends MealPlan> {

    private T plan;

    public Meal(T plan) {
        this.plan = plan;
    }

    public T getPlan() {
        return plan;
    }

    public static <T extends MealPlan> T generatePlan(String userPreference, Class<T> planType) {
        System.out.println("Attempting to generate " + userPreference + " plan...");
        try {
            // A simple (non-robust) way to create an instance based on the type parameter
            T newPlan = planType.getDeclaredConstructor().newInstance();
            System.out.println("Successfully generated a " + newPlan.getPlanName() + " Meal Plan.");
            return newPlan;
        } catch (Exception e) {
            System.out.println("Could not generate plan for preference: " + userPreference + ". Error: " + e.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {
        Meal<VegetarianMeal> vegMeal = new Meal<>(generatePlan("Vegetarian", VegetarianMeal.class));
        if (vegMeal.getPlan() != null) {
            System.out.println("Generated Plan Details: " + vegMeal.getPlan());
        }

        Meal<KetoMeal> ketoMeal = new Meal<>(generatePlan("Keto", KetoMeal.class));
        if (ketoMeal.getPlan() != null) {
            System.out.println("Generated Plan Details: " + ketoMeal.getPlan());
        }
    }
}
