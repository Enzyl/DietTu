package org.example.infrastructure.database.repository.mapper;

import org.example.domain.User;
import org.example.infrastructure.database.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserEntityMapper {

    @Mapping(target = "userMetric", ignore = true)
    @Mapping(target = "preferences", ignore = true)
    @Mapping(target = "dietPlans", ignore = true)
    User mapFromEntity(UserEntity entity);

    @Mapping(target = "userMetric", ignore = true)
    @Mapping(target = "preferences", ignore = true)
    @Mapping(target = "dietPlans", ignore = true)
    UserEntity mapToEntity(User user);
}