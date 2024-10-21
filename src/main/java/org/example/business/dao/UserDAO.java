package org.example.business.dao;

import org.example.domain.User;
import org.example.infrastructure.database.entity.UserEntity;

import java.util.Optional;

public interface UserDAO{
    Optional<User> findByUsername(String username);
    Long findIdByUsername(String username);

    void save(UserEntity user);
}
