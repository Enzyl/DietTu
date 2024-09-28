CREATE TABLE diet_plans (
    dietId SERIAL PRIMARY KEY,
    startDate VARCHAR(255),
    endDate VARCHAR(255),
    userId BIGINT,
    FOREIGN KEY (userId) REFERENCES users(userId)
);