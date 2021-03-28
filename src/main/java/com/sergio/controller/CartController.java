package com.sergio.controller;

import com.sergio.dto.OrderDto;
import com.sergio.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.transaction.Transactional;

@RestController
@Transactional
@RequestMapping(value = "/orders")
public class CartController {

    private OrderService orderService;

    @Autowired
    public CartController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping(value = "/{id}")
    public OrderDto getById(@PathVariable int id){
        return orderService.getOrderById(id);
    }
}



