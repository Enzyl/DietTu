package org.example.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class Recipe{
    private Long recipeId;
    private String name;
    private String description;
    private int totalCalories;
    private double proteins;
    private double fats;
    private double carbs;
    private int preparationTime;
    private String advanceLevel;
    private Set<Ingredient> ingredients;
}
