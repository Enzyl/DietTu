package org.example.infrastructure.database.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "recipes")
public class RecipeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recipeId")
    private Long recipeId;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "totalCalories")
    private int totalCalories;

    @Column(name = "proteins")
    private double proteins;

    @Column(name = "fats")
    private double fats;

    @Column(name = "carbs")
    private double carbs;

    @Column(name = "preparationTime")
    private int preparationTime;

    @Column(name = "advanceLevel")
    private String advanceLevel;

    // To jest relacja wiele do wielu z IngredientEntity
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "recipe_ingredients",
            joinColumns = @JoinColumn(name = "recipeId"),
            inverseJoinColumns = @JoinColumn(name = "ingredientId")
    )
    private Set<IngredientEntity> ingredients;
}
