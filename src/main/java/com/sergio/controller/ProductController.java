package com.sergio.controller;

import com.sergio.domain.Order;
import com.sergio.domain.Product;
import com.sergio.domain.User;
import com.sergio.repository.OrderRepository;
import com.sergio.service.OrderService;
import com.sergio.service.ProductService;
import com.sergio.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/chooseproducts")
public class ProductController {
    private OrderService orderService;
    private UserService userService;
    private ProductService productService;
    private OrderRepository orderRepository;

    @Autowired
    public ProductController(OrderService orderService, UserService userService, ProductService productService, OrderRepository orderRepository) {
        this.orderService = orderService;
        this.userService = userService;
        this.productService = productService;
        this.orderRepository = orderRepository;
    }

    @RequestMapping
    public String makeOrder(ModelMap model, HttpServletRequest req, Principal principal) {

        User user = userService.createOrGetUser(principal.getName());
        Order order = orderService.getCurrentOrder(principal.getName());

        if (req.getParameter("remove") != null) {
            int idToRemoveProduct = Integer.parseInt(req.getParameter("remove"));
            orderService.removeProductFromOrder(principal.getName(), idToRemoveProduct);
        } else {
            if (req.getParameterValues("selected") != null) {
                orderService.addProductToOrder(principal.getName(), Integer.parseInt(req.getParameter("selected")));
            }
        }

        order = orderService.getCurrentOrder(principal.getName());
        if(order.getProducts()!=null){
            model.addAttribute("selectedProducts", order.getProducts());
        }

        model.addAttribute("products", productService.getAllProducts());
        model.addAttribute("order", orderService.getCurrentOrder(principal.getName()));
        model.addAttribute("user", userService.createOrGetUser(principal.getName()));
        return "chooseproducts";
    }
}
