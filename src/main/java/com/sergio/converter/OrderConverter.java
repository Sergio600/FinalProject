package com.sergio.converter;

import com.sergio.domain.Order;
import com.sergio.dto.OrderDto;
import com.sergio.exception.InvalidArgumentException;
import com.sergio.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Lazy
public class OrderConverter {

    @Autowired
    ProductConverter productConverter;

    @Autowired
    UserConverter userConverter;

    @Autowired
    UserService userService;

//    @Autowired
//    public OrderConverter(ProductConverter productConverter, UserConverter userConverter, UserService userService) {
//        this.productConverter = productConverter;
//        this.userConverter = userConverter;
//        this.userService = userService;
//    }

    public Order fromDto(OrderDto dto) {
        if (dto == null) {
            throw new InvalidArgumentException("Can't be null");
        }
        Order order = new Order();
        order.setId(dto.getId());
        order.setTotalPrice(dto.getTotalPrice());
        order.setUser(userConverter.fromDto(userService.createOrGetUser(dto.getUserName())));
        order.setProducts(productConverter.fromDtoList(dto.getProducts()));
        return order;
    }

    public OrderDto toDto(Order order) {
        if (order == null) {
            throw new InvalidArgumentException("Can't be null");
        }
        OrderDto orderDto = new OrderDto();
        orderDto.setId(order.getId());
        orderDto.setTotalPrice(order.getTotalPrice());
        orderDto.setUserName(order.getUser().getLogin());
        orderDto.setProducts(productConverter.toDtoList(order.getProducts()));
        return orderDto;
    }

    public List<Order> fromDtoList(List<OrderDto> orderDtos) {
//        List<Order> orders = new ArrayList<>();
//        for (OrderDto orderDto : orderDtos) {
//            orders.add(fromDto(orderDto));
//        }
        return orderDtos
                .stream()
                .map(this::fromDto)
                .collect(Collectors.toList());

    }

    public List<OrderDto> toDtoList(List<Order> orders) {
        List<OrderDto> ordersDto = new ArrayList<>();
        for (Order order : orders) {
            ordersDto.add(toDto(order));
        }
        return ordersDto;
    }
}
