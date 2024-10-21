package org.example.domain;

public enum ActivityLevel {

    NO_ACTIVITY(1.2, "Brak lub minimalna aktywność"),
    LIGHT_ACTIVITY(1.375, "Lekka aktywność (np. ćwiczenia 1-3 razy w tygodniu)"),
    MODERATE_ACTIVITY(1.55, "Umiarkowana aktywność (np. ćwiczenia 3-5 razy w tygodniu)"),
    HIGH_ACTIVITY(1.725, "Wysoka aktywność (np. ćwiczenia 6-7 razy w tygodniu)"),
    VERY_HIGH_ACTIVITY(1.9, "Bardzo wysoka aktywność (np. zawodowe sporty, praca fizyczna)");

    private final double value;
    private final String description;

    ActivityLevel(double value, String description) {
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
