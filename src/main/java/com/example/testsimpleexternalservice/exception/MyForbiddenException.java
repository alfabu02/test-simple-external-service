package com.example.testsimpleexternalservice.exception;

import org.springframework.http.HttpStatus;

public class MyForbiddenException extends MyException {
    public MyForbiddenException(String message) {
        super(HttpStatus.FORBIDDEN, message);
    }
}
