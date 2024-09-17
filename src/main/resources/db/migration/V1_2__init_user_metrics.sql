CREATE TABLE user_metrics (
                              userMetricId SERIAL PRIMARY KEY,
                              age INT,
                              height INT,
                              calories INT,
                              currentWeight DOUBLE PRECISION,
                              activityLevel VARCHAR(255),
                              targetWeight DOUBLE PRECISION
);