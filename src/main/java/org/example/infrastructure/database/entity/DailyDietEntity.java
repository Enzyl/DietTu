package org.example.infrastructure.database.entity;

public class DailyDietEntity {
    private Long dailyDietId;
    private MealEntity meal;

    // Getters and setters
    public Long getDailyDietId() {
        return dailyDietId;
    }

    public void setDailyDietId(Long dailyDietId) {
        this.dailyDietId = dailyDietId;
    }

    public MealEntity getMeal() {
        return meal;
    }

    public void setMeal(MealEntity meal) {
        this.meal = meal;
    }
}
