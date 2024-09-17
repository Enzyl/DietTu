package org.example.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class User{
    private Long userId;
    private String username;
    private String password;
    private String email;
    private UserMetric userMetric;
    private Preferences preferences;
}
