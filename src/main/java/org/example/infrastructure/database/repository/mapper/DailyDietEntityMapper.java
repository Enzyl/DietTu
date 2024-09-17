package org.example.infrastructure.database.repository.mapper;

import org.example.domain.DailyDiet;
import org.example.infrastructure.database.entity.DailyDietEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DailyDietEntityMapper {

    @Mapping(target = "dietPlan", ignore = true)
    @Mapping(target = "meals", ignore = true)
    DailyDiet mapFromEntity(DailyDietEntity dailyDietEntity);

    @Mapping(target = "dietPlan", ignore = true)
    @Mapping(target = "meals", ignore = true)
    DailyDietEntity mapToEntity(DailyDiet dailyDiet);
}