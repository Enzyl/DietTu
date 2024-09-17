package org.example.infrastructure.database.repository;

import lombok.AllArgsConstructor;
import org.example.business.dao.UserDAO;
import org.example.domain.User;
import org.example.infrastructure.database.entity.UserEntity;
import org.example.infrastructure.database.repository.jpa.UserJpaRepository;
import org.example.infrastructure.database.repository.mapper.UserEntityMapper;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class UserRepository implements UserDAO{
    UserJpaRepository userJpaRepository;
    UserEntityMapper userEntityMapper;

    @Override
    public User findByUsername(String username) {
        Optional<UserEntity> byUsername = userJpaRepository.findByUsername(username);
        //if(byUsername.isEmpty()) throw new UsernameNotFoundException("User ["+username+"] not found");
        User user = userEntityMapper.mapFromEntity(byUsername.get());
        return user;
    }

    @Override
    public Long findIdByUsername(String username) {
        Optional<UserEntity> byUsername = userJpaRepository.findByUsername(username);
        Long id = byUsername.get().getUserId(); // dlaczego to kurwa nie działa to jebane @getter
        return id;
    }
}