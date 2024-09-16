package org.example.infrastructure.database.entity;

import jakarta.persistence.*;
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
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "mealId")
         private Long mealId;
        @Column(name = "recipe")
         private RecipeEntity recipe;
        @Column(name = "multiplier")
         private double multiplier;
        @Column(name = "mealType")
         private String mealType;


}
