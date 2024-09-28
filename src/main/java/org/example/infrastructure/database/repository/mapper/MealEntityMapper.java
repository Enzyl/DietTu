package org.example.infrastructure.database.repository.mapper;

import org.example.domain.Meal;
import org.example.infrastructure.database.entity.MealEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MealEntityMapper {

    @Mapping(target = "recipe", ignore = true)
    @Mapping(target = "dailyDiet", ignore = true)
    Meal mapFromEntity(MealEntity mealEntity);

    @Mapping(target = "recipe", ignore = true)
    @Mapping(target = "dailyDiet", ignore = true)
    MealEntity mapToEntity(Meal meal);
}