package org.example.business.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.business.dao.UserDAO;
import org.example.domain.User;
import org.example.infrastructure.database.repository.UserRepository;
import org.springframework.stereotype.Service;
@Slf4j
@Service
@AllArgsConstructor
public class UserService {
    private final UserDAO userDAO;
    public boolean verifyUser(String username, String password) {
        log.info("##### UserService ### verifyUser");
        String userPassword = userDAO.findByUsername(username).getPassword();
        if (userPassword.equals(password)){
            return true;
        }
        return false;
    }
}
