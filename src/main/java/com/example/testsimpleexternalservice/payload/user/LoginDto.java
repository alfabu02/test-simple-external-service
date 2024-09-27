package com.example.testsimpleexternalservice.payload.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record LoginDto(@Email(regexp = ".*@.*", message = "Email has not got @")
                       @NotBlank(message = "Email is required!")
                       String email,
                       @Size(min = 4, max = 30, message = "Length of password must be between 4 and 30")
                       @NotBlank(message = "Password is required!")
                       String password) {
}
