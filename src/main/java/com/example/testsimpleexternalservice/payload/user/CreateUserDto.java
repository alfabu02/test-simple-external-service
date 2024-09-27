package com.example.testsimpleexternalservice.payload.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.web.multipart.MultipartFile;

public record CreateUserDto(@NotBlank(message = "firstName is required!") String firstName,
                            @NotBlank(message = "lastName is required!") String lastName,
                            @Email(regexp = "\\w+@\\w+\\.\\w+", message = "email has not got @") @NotBlank(message = "email is required!") String email,
                            @Size(min = 4, max = 30, message = "Length of password ") @NotBlank(message = "password is required!") String password,
                            MultipartFile image) {
}
