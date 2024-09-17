package org.example.infrastructure.database.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "daily_diets")
public class DailyDietEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dailyDietId")
    private Long dailyDietId;

    // To jest relacja wiele do jednego z DietPlanEntity
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dietId", referencedColumnName = "dietId")
    private DietPlanEntity dietPlan;

    // To jest relacja jeden do wielu z MealEntity
    @OneToMany(mappedBy = "dailyDiet", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<MealEntity> meals;
}