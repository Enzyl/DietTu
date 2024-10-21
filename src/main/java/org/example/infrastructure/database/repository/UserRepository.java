package org.example.infrastructure.database.repository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.business.dao.UserDAO;
import org.example.domain.User;
import org.example.infrastructure.database.entity.UserEntity;
import org.example.infrastructure.database.repository.jpa.UserJpaRepository;
import org.example.infrastructure.database.repository.mapper.UserEntityMapper;
import org.springframework.stereotype.Repository;
import java.util.Optional;
@Slf4j
@Repository
@AllArgsConstructor
public class UserRepository implements UserDAO{
    private final UserJpaRepository userJpaRepository;
    private final UserEntityMapper userEntityMapper;

    @Override
    public Optional<User> findByUsername(String username) {
        log.info("##### UserRepository ### findByUsername");
        Optional<UserEntity> byUsername = userJpaRepository.findByUsername(username);
        //if(byUsername.isEmpty()) throw new UsernameNotFoundException("User ["+username+"] not found");
        if (byUsername.isEmpty()){
            return Optional.empty();
        }
        User user = userEntityMapper.mapFromEntity(byUsername.get());
        return Optional.of(user);
    }

    @Override
    public Long findIdByUsername(String username) {
        Optional<UserEntity> byUsername = userJpaRepository.findByUsername(username);
        Long id = byUsername.orElseThrow().getUserId(); // dlaczego to kurwa nie działa to jebane @getter - już działa, ale fajny kom to zostaje |MP|
        return id;
    }

    @Override
    public void save(UserEntity user) {
        userJpaRepository.save(user);
    }
}