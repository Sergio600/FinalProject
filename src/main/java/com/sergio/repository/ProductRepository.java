package com.sergio.repository;

import com.sergio.domain.Product;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ProductRepository {

    private SessionFactory sessionFactory;

    @Autowired
    public ProductRepository (SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    public List<Product> getAllProducts() {
        Query query = sessionFactory.getCurrentSession().createQuery("FROM Product", Product.class);
        return query.list();
    }

    public Product getProductById (int id){
        Query query = sessionFactory.getCurrentSession().createQuery("from Product p where p.id = :id");
        query.setParameter("id", id);
        return (Product) query.getSingleResult();
        }
}
