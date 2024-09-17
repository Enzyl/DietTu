package org.example.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class UserMetric{
    private Long userMetricId;
    private int age;
    private int height;
    private int calories;
    private double currentWeight;
    private String activityLevel;
    private double targetWeight;
}
