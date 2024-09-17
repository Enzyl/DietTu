package org.example.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class Meal{
    private Long mealId;
    private double multiplier;
    private String mealType;
    private Recipe recipe;
    private DailyDiet dailyDiet;
}
