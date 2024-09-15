package org.example.infrastructure.database.entity;

public class MealEntity {
        private Long mealId;
        private RecipeEntity recipe;
        private double multiplier;
        private String mealType;

        // Getters and setters
        public Long getMealId() {
            return mealId;
        }

        public void setMealId(Long mealId) {
            this.mealId = mealId;
        }

        public RecipeEntity getRecipeEntity() {
            return recipe;
        }

        public void setRecipe(RecipeEntity recipe) {
            this.recipe = recipe;
        }

        public double getMultiplier() {
            return multiplier;
        }

        public void setMultiplier(double multiplier) {
            this.multiplier = multiplier;
        }

        public String getMealType() {
            return mealType;
        }

        public void setMealType(String mealType) {
            this.mealType = mealType;
        }
}
