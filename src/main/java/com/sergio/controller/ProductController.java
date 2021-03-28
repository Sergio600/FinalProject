package com.sergio.controller;

import com.sergio.domain.Order;
import com.sergio.dto.OrderDto;
import com.sergio.dto.ProductDto;
import com.sergio.repository.OrderRepository;
import com.sergio.service.OrderService;
import com.sergio.service.ProductService;
import com.sergio.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.transaction.Transactional;
import java.security.Principal;
import java.util.List;

@RestController
@Transactional
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductService productService;

//    @Autowired
//    public ProductController(OrderService orderService, UserService userService, ProductService productService, OrderRepository orderRepository) {
//        this.orderService = orderService;
//        this.productService = productService;
//    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<OrderDto> getById(@PathVariable int id) {
        return ResponseEntity.ok(orderService.getOrderById(id));
    }


    @GetMapping(value = "/")
    public List<ProductDto> getAllProducts() {
        return productService.getAllProducts();
    }

    @PutMapping(value = "/{productId}")
    public ResponseEntity addToOrder(@PathVariable int productId, Principal principal) {
        orderService.addProductToOrder(principal.getName(), productId);
        return ResponseEntity.ok("Product is added to order");
    }
}
