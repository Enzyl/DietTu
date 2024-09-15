package org.example.infrastructure.database.entity;

public class RecipeEntity {
        private Long recipeId;
        private String name;
        private String description;
        private int totalCalories;
        private double proteins;
        private double fats;
        private double carbs;
        private IngredientEntity ingredient;
        private int preparationTime;
        private String advanceLevel;

        // Getters and setters
        public Long getRecipeId() {
            return recipeId;
        }

        public void setRecipeId(Long recipeId) {
            this.recipeId = recipeId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getTotalCalories() {
            return totalCalories;
        }

        public void setTotalCalories(int totalCalories) {
            this.totalCalories = totalCalories;
        }

        public double getProteins() {
            return proteins;
        }

        public void setProteins(double proteins) {
            this.proteins = proteins;
        }

        public double getFats() {
            return fats;
        }

        public void setFats(double fats) {
            this.fats = fats;
        }

        public double getCarbs() {
            return carbs;
        }

        public void setCarbs(double carbs) {
            this.carbs = carbs;
        }

        public IngredientEntity getIngredientEntity() {
            return ingredient;
        }

        public void setIngredientEntity(IngredientEntity ingredient) {
            this.ingredient = ingredient;
        }

        public int getPreparationTime() {
            return preparationTime;
        }

        public void setPreparationTime(int preparationTime) {
            this.preparationTime = preparationTime;
        }

        public String getAdvanceLevel() {
            return advanceLevel;
        }

        public void setAdvanceLevel(String advanceLevel) {
            this.advanceLevel = advanceLevel;
        }
    }
