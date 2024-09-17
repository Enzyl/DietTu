package org.example.infrastructure.database.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "meals")
public class MealEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mealId")
    private Long mealId;

    @Column(name = "multiplier")
    private double multiplier;

    @Column(name = "mealType")
    private String mealType;

    // To to jest relacja jeden do jednego z RecipeEntity
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "recipeId", referencedColumnName = "recipeId")
    private RecipeEntity recipe;

    // To jest relacja wiele do jednego z DailyDietEntity
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dailyDietId", referencedColumnName = "dailyDietId")
    private DailyDietEntity dailyDiet;
}
