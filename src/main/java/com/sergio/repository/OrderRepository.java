package com.sergio.repository;

import com.sergio.domain.Order;
import com.sergio.domain.Product;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Repository class that emulate data base and has some repository methods.
 */
@Repository
@Transactional
public class OrderRepository {

    private SessionFactory sessionFactory;

    @Autowired
    public OrderRepository(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    public Order save (Order order){
        sessionFactory.getCurrentSession().save(order);
        return order;
    }

    public void updateOrder (Order order){
        sessionFactory.getCurrentSession().update(order);
    }
}