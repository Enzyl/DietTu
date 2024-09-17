package org.example.business.service;

import lombok.AllArgsConstructor;
import org.example.infrastructure.database.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

}
