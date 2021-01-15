package org.vinuvicho.mapper;

import org.vinuvicho.dto.UserDTO;
import org.vinuvicho.entity.Car;
import org.vinuvicho.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserToUserDTOMapper {
    public User toEntity(final UserDTO userDTO, final List<Car> carList){
        final User user = new User();
        user.setId(userDTO.getId());
        user.setFirstname(userDTO.getFirstname());
        user.setLastname(userDTO.getLastname());
        user.setBirth(userDTO.getBirth());
        user.setOrders(carList);
        return user;
    }

    public UserDTO toDto(final User user){
        final UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setFirstname(user.getFirstname());
        userDTO.setLastname(user.getLastname());
        userDTO.setBirth(user.getBirth());
        return userDTO;
    }
}