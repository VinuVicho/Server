package org.vinuvicho.repository;

import org.vinuvicho.entity.User;
import org.vinuvicho.exception.ServiceException;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class UserRepository {

    @PostConstruct
    public void init(){
        savedUsers = new ArrayList<>();
    }

    private static Long lastId = 0L;
    private static List<User> savedUsers;

    public User getUserById(final Long id){
        return savedUsers.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ServiceException(400, "User with id: " + id + " not found ", null));
    }

    public List<User> getAllUsers(){
        return savedUsers;
    }

    public User createUser(final User user){
        if(user.getId() != null){
            throw new ServiceException(400, "User shouldn't have an id ", null);
        }
        ++lastId;
        user.setId(lastId);
        savedUsers.add(user);
        return user;
    }

    public User updateUser(final User user){
        if(user.getId() == null){
            throw new ServiceException(400, "User shouldn't have an id ", null);
        }
        final User savedUser = getUserById(user.getId());
        savedUser.setOrders(user.getOrders());
        savedUser.setBirth(user.getBirth());
        savedUser.setLastname(user.getLastname());
        savedUser.setFirstname(user.getFirstname());

        return savedUser;
    }

    public void deleteUserById(final Long id){
        if(id == null){
            throw new ServiceException(400, "Id isn't specified", null);
        }
        savedUsers.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ServiceException(400, "User with id: " + id + " not found ", null));
        savedUsers = savedUsers.stream()
                .filter(e -> !e.getId().equals(id))
                .collect(Collectors.toList());
    }

    public static boolean checkUserId(Long id) {
        if(!savedUsers.isEmpty()) {
            for (User user: savedUsers) {
                if (user.getId().equals(id)) return true;
            }
        }
        return false;
    }
}