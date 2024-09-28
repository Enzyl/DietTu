CREATE TABLE recipe_ingredients (
    recipeId BIGINT,
    ingredientId BIGINT,
    PRIMARY KEY (recipeId, ingredientId),
    FOREIGN KEY (recipeId) REFERENCES recipes(recipeId),
    FOREIGN KEY (ingredientId) REFERENCES ingredients(ingredientId)
);