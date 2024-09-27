package com.example.testsimpleexternalservice.mapper;

import com.example.testsimpleexternalservice.document.User;
import com.example.testsimpleexternalservice.payload.user.CreateUserDto;
import com.example.testsimpleexternalservice.payload.user.UserDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toDocument(CreateUserDto userDto);

    UserDto toDto(User user);

    List<UserDto> toDtoList(List<User> users);

}
