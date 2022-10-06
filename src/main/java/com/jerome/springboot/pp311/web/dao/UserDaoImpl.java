package com.jerome.springboot.pp311.web.dao;

import com.jerome.springboot.pp311.web.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    public List<User> listUsers() {
        List userList = entityManager.createQuery("from User").getResultList();
        return userList;
    }

    @Override
    public void changeUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public void removeUser(Long id) {
        entityManager.createQuery("Delete from User u where u.id = :id").setParameter("id", id).executeUpdate();
    }

    @Override
    public User findById(Long id) {
        return entityManager.find(User.class, id);
    }
}
