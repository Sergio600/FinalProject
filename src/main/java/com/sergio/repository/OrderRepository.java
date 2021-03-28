package com.sergio.repository;

import com.sergio.domain.Order;
import com.sergio.domain.Product;
import com.sergio.domain.User;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

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

    public Optional<Order> getById(int id) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Order o where o.id = :id");
        query.setParameter("id", id);

        Order order = (Order) query.getSingleResult();
        if (order == null) {
            return Optional.empty();
        } else {
            return Optional.of(order);
        }
    }}