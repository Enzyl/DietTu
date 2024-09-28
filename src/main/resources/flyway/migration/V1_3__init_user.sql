CREATE TABLE users (
   userId SERIAL PRIMARY KEY,
   username VARCHAR(255),
   password VARCHAR(255),
   email VARCHAR(255),
   preferencesId BIGINT,
   userMetricId BIGINT,
   FOREIGN KEY (preferencesId) REFERENCES preferences(preferencesId),
   FOREIGN KEY (userMetricId) REFERENCES user_metrics(userMetricId)
);