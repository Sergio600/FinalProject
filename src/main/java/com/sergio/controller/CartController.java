package com.sergio.controller;

import com.sergio.repository.OrderRepository;
import com.sergio.service.OrderService;
import com.sergio.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/cart")
public class CartController {
    private OrderService orderService;
    private UserService userService;
    private OrderRepository orderRepository;

    @Autowired
    public CartController(OrderService orderService, UserService userService, OrderRepository orderRepository) {
        this.orderService = orderService;
        this.userService = userService;
        this.orderRepository = orderRepository;
    }

    @RequestMapping
    public String showCart(Model model, Principal principal) {

//        User user = userService.createOrGetUser(principal.getName());
//        Order order = orderService.createOrGetOrder(user);
//        order.setProducts(orderRepository.getProductsByOrder(order));

        model.addAttribute("user", userService.createOrGetUser(principal.getName()));
        model.addAttribute("order", orderService.getCurrentOrder(principal.getName()));
        model.addAttribute("selectedProducts", orderService.getCurrentOrder(principal.getName()).getProducts());
        model.addAttribute("totalPrice", orderService.getCurrentOrder(principal.getName()).getTotalPrice());
        return "cart";
    }
}



