package com.mysillydreams.eventmanagement.service;

import com.mysillydreams.eventmanagement.dao.UserDAO;
import com.mysillydreams.eventmanagement.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    @Transactional
    public void createUser(UserEntity user) {

      userDAO.save(user);
    }
    @Override
    @Transactional
    public List<UserEntity> findAll(UserEntity user) {
        return userDAO.findAll(user);
    }

    @Override
    public UserEntity findById(int theId) {
        return userDAO.findById(theId);
    }

    @Override
    @Transactional
    public UserEntity update(UserEntity user) {
        return userDAO.update(user);
    }

    @Override
    @Transactional
    public void deleteById(int theId) {

        userDAO.deleteById(theId);
    }

}
