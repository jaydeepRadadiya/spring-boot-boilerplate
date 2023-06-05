package com.example.demo.service.implementation;


import com.example.demo.dto.UserDto;
import com.example.demo.dto.mappers.UserMapper;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    private  final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public UserDto createUser(UserDto newUser) {
        log.info("UserService.newUser");
        final User user = UserMapper.INSTANCE.toUserModel(newUser);
        return UserMapper.INSTANCE.toUserDto(userRepository.save(user));
    }
    public void deleteUser(Long id) {
        log.info("UserService.deleteUser");
        userRepository.deleteById(id);
    }
    public User getUser( Long id) throws UserNotFoundException {
        log.info("UserService.one");
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Id not found : " + id));
    }

    public  UserDto replaceUser( UserDto updatedUser, Long id) {
        log.info("UserService.replaceUser");
        final User userModel = UserMapper.INSTANCE.toUserModel(updatedUser);
        return UserMapper.INSTANCE.toUserDto(userRepository.findById(id)
                .map(user -> {
                    user.setName(userModel.getName());
                    user.setRole(userModel.getRole());
                    return userRepository.save(user);
                })
                .orElseGet(() -> {
                    userModel.setId(id);
                    return userRepository.save(userModel);
                }));
    }

    public List<User> getUsers(){
        log.info("UserService.findAll");
        return userRepository.findAll();
    }
}
