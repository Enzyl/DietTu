package org.example.domain;

public enum TargetActionLevel {

    LOSE_WEIGHT(1, "Chcę schudnąć"),
    KEEP_WEIGHT(2, "Chcę utrzymać wagę"),
    GAIN_WEIGHT(3, "Chcę przytyć");

    private final int value;
    private final String description;

    TargetActionLevel(int value, String description) {
        this.value = value;
        this.description = description;
    }

    public double getValue() {
        return value;
    }
    public String getDescription() {
        return description;
    }
}