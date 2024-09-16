package org.example.infrastructure.database.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "DietPlan")
public class DietPlanEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "dietId")
        private Long dietId;
        @Column(name = "startDate")
        private String startDate;
        @Column(name = "endDate")
        private String endDate;

//        @ManyToOne(fetch = FetchType.LAZY)
//        @JoinColumn(name = "user_id", referencedColumnName = "id")
//        private DailyDietEntity dailyDiet;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "dietId", referencedColumnName = "dietId")
        private UserEntity user;

}
