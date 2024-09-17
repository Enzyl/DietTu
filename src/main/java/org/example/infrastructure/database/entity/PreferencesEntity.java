package org.example.infrastructure.database.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "preferences")
public class PreferencesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "preferencesId")
    private Long preferencesId;

    @Column(name = "allergens")
    private String allergens;

    @Column(name = "comfortFood")
    private String comfortFood;
}
