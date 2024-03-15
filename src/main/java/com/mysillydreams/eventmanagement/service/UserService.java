package com.mysillydreams.eventmanagement.service;

import com.mysillydreams.eventmanagement.entity.UserEntity;

import java.util.List;

public interface UserService {

    public void createUser(UserEntity user);
    List<UserEntity> findAll(UserEntity user);
    UserEntity findById (int theId);
    UserEntity update (UserEntity user);
    void deleteById(int theId);
}
