package com.sergio.service;

import com.sergio.domain.Order;
import com.sergio.domain.Product;
import com.sergio.domain.User;
import com.sergio.exception.InvalidArgumentException;
import com.sergio.repository.OrderRepository;
import com.sergio.repository.ProductRepository;
import com.sergio.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Iterator;
import java.util.List;

@Service
public class OrderService {
    private OrderRepository orderRepository;
    private UserRepository userRepository;
    private ProductRepository productRepository;

    @Autowired
    public OrderService (OrderRepository orderRepository, UserRepository userRepository, ProductRepository productRepository){
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    public void addProductToOrder(String name, int id){
        if(name==null || id ==0){
            throw new InvalidArgumentException("Arguments cant be null");
        }
        Order current = getCurrentOrder(name);
        List<Product> products = current.getProducts();
        Product product = productRepository.getProductById(id);
        products.add(product);

        current.setProducts(products);
        current.setTotalPrice(calcTotalPrice(current));

        orderRepository.updateOrder(current);
    }

    public void removeProductFromOrder(String name, int id){
        if(name==null || id == 0){
            throw new InvalidArgumentException("Arguments cant be null");
        }
        Order current = getCurrentOrder(name);
        List<Product> products = current.getProducts();
        products = removeProductByIdFromList(products, id);
        current.setProducts(products);
        current.setTotalPrice(calcTotalPrice(current));
        orderRepository.updateOrder(current);
    }

    public List<Product> removeProductByIdFromList (List<Product> products, int id){
        Iterator iterator = products.iterator();
        while (iterator.hasNext()){
            Product product = (Product) iterator.next();
            if(product.getId()==id){
                iterator.remove();
                break;
            }
        }
        return products;
    }

    public double calcTotalPrice(Order current) {
        double totalPrice =0;

        List<Product> products = current.getProducts();
        for (Product product: products) {
            totalPrice+=product.getPrice();
        }
        return totalPrice;
    }

    public Order getCurrentOrder(String name) {
        if (name == null) {
            throw new InvalidArgumentException("Name can't be null");
        }
        User user = userRepository.getByName(name).get();
        if(user.getOrders().size() == 0){
            return orderRepository.save(new Order(user));
        } else {
           return user.getOrders().get(0);
        }
    }
}
