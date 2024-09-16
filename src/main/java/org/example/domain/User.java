package org.example.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.example.infrastructure.database.entity.PreferencesEntity;
import org.example.infrastructure.database.entity.UserMetricEntity;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class User {
    private Long userId;
    private String username;
    private String password;
    private String email;
    private UserMetricEntity userMetric;
    private PreferencesEntity preferences;
}
