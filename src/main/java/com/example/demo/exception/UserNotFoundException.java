package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import zipkin2.Call;

public class UserNotFoundException extends BaseException {
    public UserNotFoundException(String message, Throwable cause, ErrorCode errorCode) {
        super(message, cause, errorCode);
    }
    public UserNotFoundException(ErrorCode errorCode) {
        super(errorCode);
    }
    public UserNotFoundException(ErrorCode errorCode, String message)
    {
        super(message, errorCode);
    }

    @Override
    public ErrorResponse getErrorResponse() {
        return new ErrorResponse(ErrorCode.INVALID_USERID.getCode(), HttpStatus.NOT_FOUND, "user not found");
    }

}
