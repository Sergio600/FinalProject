package com.sergio.service;

import com.sergio.domain.Order;
import com.sergio.domain.User;
import com.sergio.exception.InvalidArgumentException;
import com.sergio.repository.OrderRepository;
import com.sergio.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;
    private OrderRepository orderRepository;

    @Autowired
    public UserService(UserRepository userRepository, OrderRepository orderRepository){
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
    }

    public User createOrGetUser(String userName) {
        if (userName == null) {
            throw new InvalidArgumentException("Name can't be null");
        }
        User user;
        Optional<User> optionalUser =  userRepository.getByName(userName);
        if (optionalUser.isPresent()){
            user = optionalUser.get();
        } else {
            user = new User(userName);
            orderRepository.save(new Order(user));
        }
        return user;
    }
}