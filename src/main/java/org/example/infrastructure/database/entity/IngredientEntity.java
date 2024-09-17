package org.example.infrastructure.database.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ingredients")
public class IngredientEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "ingredientId")
        private Long ingredientId;

        @Column(name = "name")
        private String name;

        @Column(name = "allergens")
        private String allergens;

        @Column(name = "measure")
        private String measure;

        // To jest relacja wiele do wielu z RecipeEntity
        @ManyToMany(mappedBy = "ingredients", fetch = FetchType.LAZY)
        private Set<RecipeEntity> recipes;
}
