package org.example.infrastructure.database.entity;

public class UserEntity {
    private Long userId;
    private String username;
    private String password;
    private String email;
    private UserMetricEntity userMetric;
    private PreferencesEntity preferences;

    // Getters and setters
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserMetricEntity getUserMetric() {
        return userMetric;
    }

    public void setUserMetric(UserMetricEntity userMetric) {
        this.userMetric = userMetric;
    }

    public PreferencesEntity getPreferences() {
        return preferences;
    }

    public void setPreferences(PreferencesEntity preferences) {
        this.preferences = preferences;
    }
}
