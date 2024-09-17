CREATE TABLE meals (
                       mealId BIGSERIAL PRIMARY KEY,
                       multiplier DOUBLE PRECISION,
                       mealType VARCHAR(255),
                       dailyDietId BIGINT,
                       recipeId BIGINT,
                       FOREIGN KEY (dailyDietId) REFERENCES daily_diets(dailyDietId),
                       FOREIGN KEY (recipeId) REFERENCES recipes(recipeId)
);