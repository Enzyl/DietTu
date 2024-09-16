package org.example.infrastructure.database.repository.jpa;

import org.example.infrastructure.database.entity.DailyDietEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DietJPARepository extends JpaRepository<DailyDietEntity, Long> {
}
