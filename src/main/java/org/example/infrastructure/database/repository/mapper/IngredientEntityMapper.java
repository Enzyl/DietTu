package org.example.infrastructure.database.repository.mapper;

import org.example.domain.Ingredient;
import org.example.infrastructure.database.entity.IngredientEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IngredientEntityMapper {

    @Mapping(target = "recipes", ignore = true)
    Ingredient mapFromEntity(IngredientEntity ingredientEntity);

    @Mapping(target = "recipes", ignore = true)
    IngredientEntity mapToEntity(Ingredient ingredient);
}