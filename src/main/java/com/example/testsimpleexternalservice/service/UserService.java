package com.example.testsimpleexternalservice.service;

import com.example.testsimpleexternalservice.payload.ApiResponse;
import com.example.testsimpleexternalservice.payload.user.CreateUserDto;
import com.example.testsimpleexternalservice.payload.user.LoginDto;
import com.example.testsimpleexternalservice.payload.user.UserDto;

import java.util.List;

public interface UserService {
    ApiResponse<UserDto> createUser(CreateUserDto userDto);

    ApiResponse<List<UserDto>> getUsers();

    ApiResponse<String> login(LoginDto loginDto);
}
