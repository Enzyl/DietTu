package org.example.infrastructure.database.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    private Long userId;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    // To jest relacja jeden do jednego z PreferencesEntity
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "preferencesId", referencedColumnName = "preferencesId")
    private PreferencesEntity preferences;

    // To jest relacja jeden do jednego z UserMetricEntity
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userMetricId", referencedColumnName = "userMetricId")
    private UserMetricEntity userMetricEntity;

    // To jest relacja wiele do jednego z DietPlanEntity
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<DietPlanEntity> dietPlans;
}
