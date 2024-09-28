CREATE TABLE daily_diets (
 dailyDietId SERIAL PRIMARY KEY,
 dietId BIGINT,
 FOREIGN KEY (dietId) REFERENCES diet_plans(dietId)
);