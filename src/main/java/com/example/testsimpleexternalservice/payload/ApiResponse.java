package com.example.testsimpleexternalservice.payload;

import java.util.Collections;
import java.util.List;

public record ApiResponse<T>(boolean success, int customStatus, T data, String message, List<ErrorDto> errors) {

    public static <S> ApiResponse<S> success(S data) {
        return new ApiResponse<>(true, 0, data, null, null);
    }

    public static <S> ApiResponse<S> successWithMessage(S data, String message) {
        return new ApiResponse<>(true, 0, data, message, null);
    }

    public static ApiResponse<Object> simpleError(String message, int errorCode) {
        return new ApiResponse<>(false, 0, null, null, Collections.singletonList(ErrorDto.simpleErrorDto(message, errorCode)));
    }

    public static ApiResponse<Object> simpleError(String message) {
        return new ApiResponse<>(false, 0, null, null, Collections.singletonList(ErrorDto.simpleErrorDto(message, 0)));
    }

    public static ApiResponse<Object> error(List<ErrorDto> errors) {
        return new ApiResponse<>(false, 0, null, null, errors);
    }

}
