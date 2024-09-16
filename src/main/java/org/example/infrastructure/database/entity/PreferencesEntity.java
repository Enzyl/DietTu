package org.example.infrastructure.database.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Preferences")
public class PreferencesEntity {
    private Long preferencesId;
    private String allergens;
    private String comfortFood;


}


