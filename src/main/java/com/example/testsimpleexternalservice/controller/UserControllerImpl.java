package com.example.testsimpleexternalservice.controller;

import com.example.testsimpleexternalservice.payload.ApiResponse;
import com.example.testsimpleexternalservice.payload.user.CreateUserDto;
import com.example.testsimpleexternalservice.payload.user.LoginDto;
import com.example.testsimpleexternalservice.payload.user.UserDto;
import com.example.testsimpleexternalservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserControllerImpl implements UserController {
    private final UserService userService;

    @Override
    public ApiResponse<UserDto> createUser(CreateUserDto userDto) {
        return userService.createUser(userDto);
    }

    @Override
    public ApiResponse<String> getToken(LoginDto loginDto) {
        return userService.login(loginDto);
    }

    @Override
    public ApiResponse<List<UserDto>> getUsers() {
        return userService.getUsers();
    }
}
