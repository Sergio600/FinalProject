package com.sergio.converter;

import com.sergio.domain.Order;
import com.sergio.dto.OrderDto;
import com.sergio.exception.InvalidArgumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
@Lazy
public class OrderConverter {

    ProductConverter productConverter;
    UserConverter userConverter;

    @Autowired
    public OrderConverter(ProductConverter productConverter, UserConverter userConverter) {
        this.productConverter = productConverter;
        this.userConverter = userConverter;
    }

    public Order fromDto(OrderDto dto) {
        if (dto == null) {
            throw new InvalidArgumentException("Can't be null");
        }
        Order order = new Order();
        order.setId(dto.getId());
        order.setTotalPrice(dto.getTotalPrice());
        order.setUser(userConverter.fromDto(dto.getUser()));
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
        orderDto.setUser(userConverter.toDto(order.getUser()));
        orderDto.setProducts(productConverter.toDtoList(order.getProducts()));
        return orderDto;
    }

    public List<Order> fromDtoList(List<OrderDto> dto) {
        List<Order> orders = new ArrayList<>();
        for (OrderDto orderDto : dto) {
            orders.add(fromDto(orderDto));
        }
        return orders;
    }

    public List<OrderDto> toDtoList(List<Order> orders) {
        List<OrderDto> ordersDto = new ArrayList<>();
        for (Order order : orders) {
            ordersDto.add(toDto(order));
        }
        return ordersDto;
    }
}
