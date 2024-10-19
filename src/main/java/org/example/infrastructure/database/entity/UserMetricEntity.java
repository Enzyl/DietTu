package org.example.infrastructure.database.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_metrics")
public class UserMetricEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userMetricId")
    private Long userMetricId;

    @Column(name = "age")
    private int age;

    @Column(name = "height")
    private int height;

    @Column(name = "calories")
    private int calories;

    @Column(name = "currentWeight")
    private double currentWeight;

    @Column(name = "activityLevel")
    private int activityLevel;

    @Column(name = "targetAction")
    private int targetAction;
}
