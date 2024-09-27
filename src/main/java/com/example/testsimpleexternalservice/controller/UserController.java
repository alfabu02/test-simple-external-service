package com.example.testsimpleexternalservice.controller;

import com.example.testsimpleexternalservice.constant.PathConstant;
import com.example.testsimpleexternalservice.payload.ApiResponse;
import com.example.testsimpleexternalservice.payload.user.CreateUserDto;
import com.example.testsimpleexternalservice.payload.user.LoginDto;
import com.example.testsimpleexternalservice.payload.user.UserDto;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(PathConstant.UserPathConstant.BASE_PATH)
public interface UserController {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    ApiResponse<UserDto> createUser(@Valid @ModelAttribute CreateUserDto userDto);

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PostMapping("/login")
    ApiResponse<String> getToken(@Valid @RequestBody LoginDto loginDto);


    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    ApiResponse<List<UserDto>> getUsers();
}
