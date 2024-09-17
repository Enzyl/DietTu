package org.example.infrastructure.database.repository.mapper;

import org.example.domain.UserMetric;
import org.example.infrastructure.database.entity.UserMetricEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMetricEntityMapper {
    UserMetric mapFromEntity(UserMetricEntity userMetricEntity);
    UserMetricEntity mapToEntity(UserMetric userMetric);
}