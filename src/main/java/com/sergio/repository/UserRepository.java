package com.sergio.repository;

import com.sergio.domain.User;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public class UserRepository {

    private SessionFactory sessionFactory;

    @Autowired
    public UserRepository(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    /**
     * Adds user to users and to Data Base
     *
     * @param user
     * @return user with id from DB
     */
    public User save(User user) {
        sessionFactory.getCurrentSession().save(user);
        return user;
    }

    /**
     * Create or get user from DB
     *
     * @param customer
     * @return
     */
    public Optional<User> getByName(String customer) {
        Query query = sessionFactory.getCurrentSession().createQuery("from User u where u.login = :login");
        query.setParameter("login", customer);
        User user = (User) query.getSingleResult();
        if (user == null) {
            return Optional.empty();
        } else {
            return Optional.of((User) user);
        }
    }
}
