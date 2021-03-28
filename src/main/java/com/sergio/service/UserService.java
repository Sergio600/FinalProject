package com.sergio.service;

import com.sergio.converter.UserConverter;
import com.sergio.domain.Order;
import com.sergio.domain.User;
import com.sergio.dto.UserDto;
import com.sergio.exception.InvalidArgumentException;
import com.sergio.exception.ResourceNotFoundException;
import com.sergio.repository.OrderRepository;
import com.sergio.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;
    private OrderRepository orderRepository;
    private UserConverter userConverter;

    @Autowired
    public UserService(UserRepository userRepository, OrderRepository orderRepository, UserConverter userConverter) {
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
        this.userConverter = userConverter;
    }

    public UserDto createOrGetUser(String login) {
        if (login == null || login =="") {
            throw new InvalidArgumentException("Name can't be null!");
        }
        User user;
        Optional<User> optionalUser = userRepository.getByName(login);
        if (optionalUser.isPresent()) {
            user = optionalUser.get();
        } else {
            throw new InvalidArgumentException("Name can't be null!");
        }
        return userConverter.toDto(user);
    }


}