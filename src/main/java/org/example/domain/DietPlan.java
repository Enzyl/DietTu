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
public class DietPlan{
    private Long dietId;
    private String startDate;
    private String endDate;
    private User user;
    private List<DailyDiet> dailyDiets;
}
