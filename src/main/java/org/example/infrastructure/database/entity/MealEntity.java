package org.example.infrastructure.database.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Meal")
public class MealEntity {
        private Long mealId;
        private RecipeEntity recipe;
        private double multiplier;
        private String mealType;


}
