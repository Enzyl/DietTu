package org.example.infrastructure.database.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "diet_plans")
public class DietPlanEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "dietId")
        private Long dietId;

        @Column(name = "startDate")
        private String startDate;

        @Column(name = "endDate")
        private String endDate;

        // To jest relacja wiele do jednego z UserEntity
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "userId", referencedColumnName = "userId")
        private UserEntity user;

        // To jest relacja jeden do wielu z DailyDietEntity
        @OneToMany(mappedBy = "dietPlan", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
        private List<DailyDietEntity> dailyDiets;
}
