-- Insert sample preferences
INSERT INTO preferences (allergens, comfortFood)
VALUES ('gluten', 'pizza'),
       ('lactose', 'ice cream'),
       ('none', 'salad'),
       ('nuts', 'pasta');

-- Insert sample user metrics
INSERT INTO user_metrics (age, height, calories, currentWeight, activityLevel, targetWeight)
VALUES (25, 180, 2500, 80.0, 'moderate', 75.0),
       (30, 165, 2000, 65.0, 'low', 60.0),
       (22, 170, 2200, 70.0, 'high', 68.0),
       (28, 175, 2300, 85.0, 'moderate', 78.0);

-- Insert sample users
INSERT INTO users (username, password, email, preferencesId, userMetricId)
VALUES ('john_doe', 'password123', 'john@example.com', 1, 1),
       ('jane_doe', 'password123', 'jane@example.com', 2, 2),
       ('alice', 'password123', 'alice@example.com', 3, 3),
       ('bob', 'password123', 'bob@example.com', 4, 4);

-- Insert sample ingredients
INSERT INTO ingredients (name, allergens, measure)
VALUES ('chicken breast', 'none', '200g'),
       ('egg', 'none', '1 piece'),
       ('milk', 'lactose', '200ml'),
       ('flour', 'gluten', '100g'),
       ('peanut butter', 'nuts', '2 tbsp'),
       ('rice', 'none', '150g'),
       ('tomato', 'none', '1 piece'),
       ('olive oil', 'none', '1 tbsp'),
       ('broccoli', 'none', '100g'),
       ('pasta', 'gluten', '100g');

-- Insert sample recipes
INSERT INTO recipes (name, description, totalCalories, proteins, fats, carbs, preparationTime, advanceLevel)
VALUES ('Grilled Chicken Salad', 'Grilled chicken breast served with fresh vegetables.', 350, 40.0, 10.0, 15.0, 20,
        'easy'),
       ('Spaghetti Bolognese', 'Pasta served with beef tomato sauce.', 600, 25.0, 20.0, 80.0, 40, 'medium'),
       ('Peanut Butter Smoothie', 'A smoothie with banana, milk, and peanut butter.', 400, 15.0, 25.0, 40.0, 10,
        'easy'),
       ('Vegetable Stir Fry', 'Mixed vegetables stir-fried with soy sauce.', 250, 5.0, 10.0, 35.0, 15, 'easy'),
       ('Chicken Curry', 'Chicken in a creamy curry sauce served with rice.', 550, 35.0, 20.0, 50.0, 30, 'medium'),
       ('Omelette', 'Egg omelette with tomato and cheese.', 300, 20.0, 22.0, 5.0, 10, 'easy'),
       ('Broccoli Pasta', 'Pasta with broccoli and olive oil.', 500, 15.0, 18.0, 65.0, 25, 'medium'),
       ('Banana Pancakes', 'Pancakes made with banana and flour.', 450, 10.0, 15.0, 60.0, 20, 'easy');

-- Insert sample recipe ingredients
INSERT INTO recipe_ingredients (recipeId, ingredientId)
VALUES (1, 1),
       (1, 7),
       (1, 9),
       (2, 10),
       (2, 4),
       (3, 3),
       (3, 5),
       (4, 7),
       (4, 9),
       (4, 8),
       (5, 1),
       (5, 3),
       (5, 6),
       (6, 2),
       (6, 7),
       (7, 10),
       (7, 9),
       (7, 8),
       (8, 4),
       (8, 2);

-- Insert sample diet plans
INSERT INTO diet_plans (startDate, endDate, userId)
VALUES ('2024-10-01', '2024-10-07', 1),
       ('2024-10-08', '2024-10-14', 2),
       ('2024-10-01', '2024-10-14', 3),
       ('2024-10-15', '2024-10-21', 4);

-- Insert sample daily diets
INSERT INTO daily_diets (dietId)
VALUES (1),
       (1),
       (1),
       (1),
       (1),
       (1),
       (1),
       (2),
       (2),
       (2),
       (2),
       (2),
       (2),
       (2),
       (3),
       (3),
       (3),
       (3),
       (3),
       (3),
       (3),
       (3),
       (3),
       (3),
       (3),
       (3),
       (3),
       (3);

-- Insert sample meals
INSERT INTO meals (multiplier, mealType, dailyDietId, recipeId)
VALUES (1.0, 'breakfast', 1, 6),
       (1.0, 'lunch', 1, 1),
       (1.0, 'dinner', 1, 5),
       (1.0, 'breakfast', 2, 8),
       (1.0, 'lunch', 2, 2),
       (1.0, 'dinner', 2, 7),
       (1.0, 'breakfast', 3, 3),
       (1.0, 'lunch', 3, 4),
       (1.0, 'dinner', 3, 1),
       (1.0, 'breakfast', 4, 6),
       (1.0, 'lunch', 4, 5),
       (1.0, 'dinner', 4, 2);