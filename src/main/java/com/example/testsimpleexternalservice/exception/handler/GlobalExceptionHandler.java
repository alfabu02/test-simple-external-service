package com.example.testsimpleexternalservice.exception.handler;

import com.example.testsimpleexternalservice.exception.MyException;
import com.example.testsimpleexternalservice.exception.MyForbiddenException;
import com.example.testsimpleexternalservice.payload.ApiResponse;
import com.example.testsimpleexternalservice.payload.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ApiResponse<Object> handleMethodArgumentNotValidException(final MethodArgumentNotValidException ex) {
        List<ErrorDto> list = ex.getAllErrors()
                .stream()
                .map(er -> new ErrorDto(er.getDefaultMessage(), er.getObjectName(), 400))
                .toList();

        return ApiResponse.error(list);
    }

    @ExceptionHandler(MyException.class)
    public ResponseEntity<ApiResponse<Object>> handleMethodArgumentNotValidException(final MyException ex) {
        final var apiResponse = ApiResponse.simpleError(ex.getMessage(), ex.getStatus().value());
        return ResponseEntity
                .status(ex.getStatus())
                .body(apiResponse);
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<ApiResponse<Object>> handleBadCredentialsException(final BadCredentialsException ex) {
        return ResponseEntity
                .status(HttpStatus.FORBIDDEN)
                .body(ApiResponse.simpleError(ex.getMessage(), 403));
    }

}
