package com.in28minutes.springboot.web.service;

import com.in28minutes.springboot.web.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
@Transactional
public class UserDAOService {

    @PersistenceContext
    private EntityManager entityManager;

    public long saveUser(User user){
        entityManager.persist(user);
        return user.getId();
    }
}
