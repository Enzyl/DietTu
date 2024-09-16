package org.example.infrastructure.database.entity;

import jakarta.persistence.*;
import lombok.*;
import org.example.domain.DietPlan;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "User")
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

    //private UserMetricEntity userMetric;
    //private PreferencesEntity preferences;


    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<DietPlanEntity> diet;
}
