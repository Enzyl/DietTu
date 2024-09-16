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
@Table(name = "Ingredient")
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


}
