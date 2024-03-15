package com.mysillydreams.eventmanagement.dao;

import com.mysillydreams.eventmanagement.entity.UserEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Id;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOJpaImpl implements UserDAO{

    EntityManager entityManager;

    @Autowired
    public UserDAOJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(UserEntity user) {
        entityManager.persist(user);
    }

    @Override
    public List<UserEntity> findAll(UserEntity user) {

        TypedQuery<UserEntity> theQuery = entityManager.createQuery("FROM UserEntity", UserEntity.class);
        List<UserEntity> userList = theQuery.getResultList();
        return userList;
    }

    @Override
    public UserEntity findById(int theId) {

        UserEntity thedata = entityManager.find(UserEntity.class, theId);
        return thedata;
    }

    @Override
    public UserEntity update(UserEntity user) {
        UserEntity theUser = entityManager.merge(user);
        return theUser;
    }

    @Override
    public void deleteById(int theId) {

        // find user Id
        UserEntity theUser = entityManager.find(UserEntity.class, theId);

        // remove user
        entityManager.remove(theUser);
    }
}
