package org.example.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class DailyDiet{
    private Long dailyDietId;
    private DietPlan dietPlan;
    private List<Meal> meals;
}
