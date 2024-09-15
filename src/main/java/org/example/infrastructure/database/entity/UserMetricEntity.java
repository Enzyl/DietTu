package org.example.infrastructure.database.entity;

public class UserMetricEntity {
    private Long userMetricId;
    private int age;
    private int height;
    private int calories;
    private double currentWeight;
    private String activityLevel;
    private double targetWeight;

    // Getters and setters
    public Long getUserMetricId() {
        return userMetricId;
    }

    public void setUserMetricId(Long userMetricId) {
        this.userMetricId = userMetricId;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public double getCurrentWeight() {
        return currentWeight;
    }

    public void setCurrentWeight(double currentWeight) {
        this.currentWeight = currentWeight;
    }

    public String getActivityLevel() {
        return activityLevel;
    }

    public void setActivityLevel(String activityLevel) {
        this.activityLevel = activityLevel;
    }

    public double getTargetWeight() {
        return targetWeight;
    }

    public void setTargetWeight(double targetWeight) {
        this.targetWeight = targetWeight;
    }
}