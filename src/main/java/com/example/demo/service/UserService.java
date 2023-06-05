package com.example.demo.service;

import com.example.demo.dto.UserDto;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.User;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto newUser);
    List<User> getUsers();
    UserDto replaceUser( UserDto updatedUser, Long id);
    void deleteUser(Long id);
    User getUser( Long id) throws UserNotFoundException;
}
