package org.example.infrastructure.database.repository.mapper;

import org.example.domain.Recipe;
import org.example.infrastructure.database.entity.RecipeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RecipeEntityMapper {

    @Mapping(target = "ingredients", ignore = true)
    Recipe mapFromEntity(RecipeEntity recipeEntity);

    @Mapping(target = "ingredients", ignore = true)
    RecipeEntity mapToEntity(Recipe recipe);
}