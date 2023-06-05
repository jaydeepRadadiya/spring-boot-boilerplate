package com.example.demo.controller;

import com.example.demo.controller.params.UserRequest;
import com.example.demo.controller.params.UserResponse;
import com.example.demo.dto.UserDto;
import com.example.demo.dto.mappers.UserMapper;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.service.UserService;
import com.example.demo.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    List<User> getUsers() {
        return userService.getUsers();
    }

    @PostMapping("/users")
    UserResponse createUser(@RequestBody UserRequest newUser) {
        final UserDto userDto = UserMapper.INSTANCE.toUserDto(newUser);
        return UserMapper.INSTANCE.toUserResponse(userService.createUser(userDto));
    }

    @PutMapping("/users/{id}")
    UserResponse replaceUser(@RequestBody UserRequest updateUserRequest, @PathVariable Long id) {
        final UserDto userDto = UserMapper.INSTANCE.toUserDto(updateUserRequest);
        return UserMapper.INSTANCE.toUserResponse(userService.replaceUser(userDto, id));
    }

    @GetMapping("/users/{id}")
    User getUser(@PathVariable Long id) throws UserNotFoundException {
        return userService.getUser(id);
    }


    @DeleteMapping("/users/{id}")
    void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

}
