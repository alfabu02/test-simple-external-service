package com.example.testsimpleexternalservice.exception;

import org.springframework.http.HttpStatus;

public class MyConflictException extends MyException {
    public MyConflictException(String message) {
        super(HttpStatus.CONFLICT, message);
    }
}
