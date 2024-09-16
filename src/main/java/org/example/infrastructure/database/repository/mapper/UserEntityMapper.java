package org.example.infrastructure.database.repository.mapper;

import org.example.domain.User;
import org.example.infrastructure.database.entity.PreferencesEntity;
import org.example.infrastructure.database.entity.UserEntity;
import org.example.infrastructure.database.entity.UserMetricEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.springframework.context.annotation.Bean;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserEntityMapper {

    @Mapping(target = "userMetric", ignore = true)
    @Mapping(target = "preferences", ignore = true)
    User mapFromEntity(UserEntity entity);

    @Mapping(target = "userMetric", ignore = true)
    @Mapping(target = "preferences", ignore = true)
    UserEntity mapToEntity(UserEntity entity);

}
