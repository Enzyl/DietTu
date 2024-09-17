package org.example.business.dao;

import org.example.domain.User;

public interface UserDAO{
    User findByUsername(String username);
    Long findIdByUsername(String username);
}
