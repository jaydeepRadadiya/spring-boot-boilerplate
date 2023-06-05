package com.example.demo.dto.mappers;

import com.example.demo.controller.params.UserRequest;
import com.example.demo.controller.params.UserResponse;
import com.example.demo.dto.UserDto;
import com.example.demo.model.User;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-05T13:02:46+0530",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 20.0.1 (Oracle Corporation)"
)
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDto toUserDto(UserRequest userRequest) {
        if ( userRequest == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setName( userRequest.getName() );
        userDto.setRole( userRequest.getRole() );

        return userDto;
    }

    @Override
    public UserDto toUserDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setId( user.getId() );
        userDto.setName( user.getName() );
        userDto.setRole( user.getRole() );

        return userDto;
    }

    @Override
    public User toUserModel(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        User user = new User();

        user.setId( userDto.getId() );
        user.setName( userDto.getName() );
        user.setRole( userDto.getRole() );

        return user;
    }

    @Override
    public UserResponse toUserResponse(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        UserResponse userResponse = new UserResponse();

        userResponse.setId( userDto.getId() );
        userResponse.setName( userDto.getName() );
        userResponse.setRole( userDto.getRole() );

        return userResponse;
    }
}
