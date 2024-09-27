package com.example.testsimpleexternalservice.exception;

import org.springframework.http.HttpStatus;

public class MyNotFoundException extends MyException {
    public MyNotFoundException(String message) {
        super(HttpStatus.NOT_FOUND, message);
    }
}
