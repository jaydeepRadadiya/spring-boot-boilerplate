package com.example.demo.dto.mappers;

import com.example.demo.controller.params.UserRequest;
import com.example.demo.controller.params.UserResponse;
import com.example.demo.dto.UserDto;
import com.example.demo.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    final UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    UserDto toUserDto(UserRequest userRequest);
    UserDto toUserDto(User user);
    User toUserModel(UserDto userDto);
    UserResponse toUserResponse(UserDto userDto);

}
