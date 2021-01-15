package org.vinuvicho.service.impl;

import org.vinuvicho.dto.UserDTO;
import org.vinuvicho.entity.User;
import org.vinuvicho.exception.ServiceException;
import org.vinuvicho.mapper.UserToUserDTOMapper;
import org.vinuvicho.repository.UserRepository;
import org.vinuvicho.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserToUserDTOMapper userMapper;

    @Override
    public UserDTO getUserById(final Long id) {
        return userMapper.toDto(userRepository.getUserById(id));
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.getAllUsers().stream()
                .map(e -> userMapper.toDto(e))
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO createUser(final UserDTO userDTO) {

        if(userDTO.getId() != null){
            throw new ServiceException(400, "User shouldn't have an id ", null);
        }

        return userMapper.toDto(userRepository.createUser(userMapper.toEntity(userDTO, null)));
    }

    @Override
    public UserDTO updateUser(final UserDTO userDTO) {

        if(userDTO.getId() == null){
            throw new ServiceException(400, "User doesn't have an id ", null);
        }

        return userMapper.toDto(userRepository.updateUser(userMapper.toEntity(userDTO, null)));
    }

    @Override
    public void deleteUserById(final Long id) {
        userRepository.deleteUserById(id);
    }
}