package org.example.infrastructure.database.entity;

public class IngredientEntity {
        private Long ingredientId;
        private String name;
        private String allergens;
        private String measure;

        // Getters and setters
        public Long getIngredientId() {
            return ingredientId;
        }

        public void setIngredientId(Long ingredientId) {
            this.ingredientId = ingredientId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAllergens() {
            return allergens;
        }

        public void setAllergens(String allergens) {
            this.allergens = allergens;
        }

        public String getMeasure() {
            return measure;
        }

        public void setMeasure(String measure) {
            this.measure = measure;
        }
}
