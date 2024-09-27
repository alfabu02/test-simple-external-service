package com.example.testsimpleexternalservice.payload;

public record ErrorDto(String message, String reason, int errorCode) {
    public static ErrorDto simpleErrorDto(String message, int errorCode) {
        return new ErrorDto(message, null, errorCode);
    }
}
