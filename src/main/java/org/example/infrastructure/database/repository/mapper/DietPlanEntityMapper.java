package org.example.infrastructure.database.repository.mapper;

import org.example.domain.DietPlan;
import org.example.infrastructure.database.entity.DietPlanEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DietPlanEntityMapper {

    @Mapping(target = "user", ignore = true)
    @Mapping(target = "dailyDiets", ignore = true)
    DietPlan mapFromEntity(DietPlanEntity dietPlanEntity);

    @Mapping(target = "user", ignore = true)
    @Mapping(target = "dailyDiets", ignore = true)
    DietPlanEntity mapToEntity(DietPlan dietPlan);
}