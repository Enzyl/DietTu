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
public class Ingredient{
    private Long ingredientId;
    private String name;
    private String allergens;
    private String measure;
    private Set<Recipe> recipes;
}
