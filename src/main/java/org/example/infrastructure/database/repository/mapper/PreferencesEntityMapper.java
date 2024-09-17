package org.example.infrastructure.database.repository.mapper;

import org.example.domain.Preferences;
import org.example.infrastructure.database.entity.PreferencesEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PreferencesEntityMapper {

    Preferences mapFromEntity(PreferencesEntity preferencesEntity);

    PreferencesEntity mapToEntity(Preferences preferences);
}