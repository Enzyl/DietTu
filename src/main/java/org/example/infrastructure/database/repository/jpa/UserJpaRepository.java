package org.example.infrastructure.database.repository.jpa;

import org.example.infrastructure.database.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserJpaRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByUsername(String username);
    Optional<UserEntity> findByEmail(String email);


    // @Query("SELECT r FROM RestaurantEntity r JOIN r.ownerEntity o JOIN o.user u WHERE u.username = :username")
    //String someDUpaMethod(String dupa);
}
