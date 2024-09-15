package org.example.infrastructure.database.entity;

public class DietPlanEntity {
    public class DietPlan {
        private Long dietId;
        private UserEntity user;
        private String startDate;
        private String endDate;
        private DailyDietEntity dailyDiet;

        // Getters and setters
        public Long getDietId() {
            return dietId;
        }

        public void setDietId(Long dietId) {
            this.dietId = dietId;
        }

        public UserEntity getUser() {
            return user;
        }

        public void setUser(UserEntity user) {
            this.user = user;
        }

        public String getStartDate() {
            return startDate;
        }

        public void setStartDate(String startDate) {
            this.startDate = startDate;
        }

        public String getEndDate() {
            return endDate;
        }

        public void setEndDate(String endDate) {
            this.endDate = endDate;
        }

        public DailyDietEntity getDailyDiet() {
            return dailyDiet;
        }

        public void setDailyDiet(DailyDietEntity dailyDiet) {
            this.dailyDiet = dailyDiet;
        }
    }
}
