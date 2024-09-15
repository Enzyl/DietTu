package org.example.infrastructure.database.entity;

public class PreferencesEntity {
    private Long preferencesId;
    private String allergens;
    private String comfortFood;

    // Getters and setters
    public Long getPreferencesId() {
        return preferencesId;
    }

    public void setPreferencesId(Long preferencesId) {
        this.preferencesId = preferencesId;
    }

    public String getAllergens() {
        return allergens;
    }

    public void setAllergens(String allergens) {
        this.allergens = allergens;
    }

    public String getComfortFood() {
        return comfortFood;
    }

    public void setComfortFood(String comfortFood) {
        this.comfortFood = comfortFood;
    }
}


