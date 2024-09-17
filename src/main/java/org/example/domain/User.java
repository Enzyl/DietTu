package org.example.domain;

import lombok.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User{
    private Long userId;
    private String username;
    private String password;
    private String email;
    private UserMetric userMetric;
    private Preferences preferences;
    private List<DietPlan> dietPlans;
}
