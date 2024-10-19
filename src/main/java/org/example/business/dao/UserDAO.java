package org.example.business.dao;

import org.example.domain.User;
import org.example.infrastructure.database.entity.UserEntity;

public interface UserDAO{
    User findByUsername(String username);
    Long findIdByUsername(String username);

    void save(UserEntity user);
}
