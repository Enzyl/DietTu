package org.example.infrastructure.database.repository;

import org.example.business.dao.UserDAO;
import org.example.domain.User;
import org.example.infrastructure.database.entity.UserEntity;
import org.example.infrastructure.database.repository.jpa.UserJpaRepository;
import org.example.infrastructure.database.repository.mapper.UserEntityMapper;
import java.util.Optional;

public class UserRepository implements UserDAO{
    ClientJpaRepository clientJpaRepository;
    UserJpaRepository userJpaRepository;
    UserEntityMapper userEntityMapper;
    private final OwnerJpaRepository ownerJpaRepository;

    @Override
    public User findByUsername(String username) {
        Optional<UserEntity> byUsername = userJpaRepository.findByUsername(username);
        if (byUsername.isEmpty()){
            throw new UsernameNotFoundException("User ["+username+"] not found");
        }
        User user = userEntityMapper.mapFromEntity(byUsername.get());
        return user;
    }

    @Override
    public Long findIdByUsername(String username) {
        Optional<UserEntity> byUsername = userJpaRepository.findByUsername(username);
        Long id = byUsername.get().getId();
        return id;
    }

    @Override
    public User findByClientId(Long clientId) {
        ClientEntity clientEntity = clientJpaRepository.findById(clientId).orElseThrow(
                () -> new RuntimeException("Client not found with id: " + clientId));
        UserEntity userEntity = userJpaRepository.findById(clientEntity.getUser().getId()).orElseThrow(
                () -> new RuntimeException("User not found with id: " + clientEntity.getUser().getId()));
        User user = userEntityMapper.mapFromEntity(userEntity);
        return user;
    }

    @Override
    public User findByOwnerId(Long ownerId) {
        OwnerEntity ownerEntity = ownerJpaRepository.findById(ownerId).orElseThrow(
                () -> new RuntimeException("Owner not found with id: " + ownerId));
        UserEntity userEntity = userJpaRepository.findById(ownerEntity.getUser().getId()).orElseThrow(
                () -> new RuntimeException("User not found with id: " + ownerEntity.getUser().getId()));
        User user = userEntityMapper.mapFromEntity(userEntity);
        return user;
    }
}
