package com.sergio.converter;

import com.sergio.domain.User;
import com.sergio.dto.UserDto;
import com.sergio.exception.InvalidArgumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class UserConverter {

    OrderConverter orderConverter;

    @Autowired
    public UserConverter (OrderConverter orderConverter){
        this.orderConverter = orderConverter;
    }

    public User fromDto(UserDto dto) {
        if (dto == null) {
            throw new InvalidArgumentException("Can't be null");
        }
        User user = new User();
        user.setId(dto.getId());
        user.setLogin(dto.getLogin());
        user.setOrders(orderConverter.fromDtoList(dto.getOrders()));
        return user;
    }

    public UserDto toDto(User user) {
        if (user == null) {
            throw new InvalidArgumentException("Can't be null");
        }

        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setLogin(user.getLogin());
        userDto.setOrders(orderConverter.toDtoList(user.getOrders()));
        return userDto;
    }
}
