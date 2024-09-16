package org.example.business;

import org.example.domain.Preferences;
import org.example.domain.User;
import org.example.infrastructure.database.entity.UserEntity;
import org.example.infrastructure.database.repository.mapper.UserEntityMapper;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public String showUserData(){
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername("Adam");
        userEntity.setPassword("123");
        userEntity.setUserId(1L);
        userEntity.setEmail("example@gmail.com");
        System.out.println(userEntity);



        return null;
    };
}
