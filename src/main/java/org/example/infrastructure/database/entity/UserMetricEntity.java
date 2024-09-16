package org.example.infrastructure.database.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "UserMetric")
public class UserMetricEntity {
    private Long userMetricId;
    private int age;
    private int height;
    private int calories;
    private double currentWeight;
    private String activityLevel;
    private double targetWeight;

}