CREATE TABLE recipes (
                         recipeId SERIAL PRIMARY KEY,
                         name VARCHAR(255),
                         description TEXT,
                         totalCalories INT,
                         proteins DOUBLE PRECISION,
                         fats DOUBLE PRECISION,
                         carbs DOUBLE PRECISION,
                         preparationTime INT,
                         advanceLevel VARCHAR(255)
);