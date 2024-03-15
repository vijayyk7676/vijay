package com.mysillydreams.eventmanagement.dao;

import com.mysillydreams.eventmanagement.entity.UserEntity;

import java.util.List;

public interface UserDAO {

    void save(UserEntity user);

    List<UserEntity> findAll(UserEntity user);

    UserEntity findById (int theId);

    UserEntity update (UserEntity user);
    void deleteById(int theId);

}