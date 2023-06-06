package com.example.demo.exception;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.http.HttpStatus;

import java.util.Optional;

public class BaseException extends RuntimeException  {

    private final ErrorCode errorCode;

    public BaseException(final String message,
                                      final ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
    protected BaseException(final String message,
                            final Throwable cause,
                            final ErrorCode errorCode) {
        super(message, cause);
        this.errorCode = errorCode;
    }
    public BaseException(final ErrorCode errorCode) {
        this(errorCode.getDefaultErrorMessage(), errorCode);
    }
    public ErrorCode getErrorCode() {
        return errorCode;
    }

    @Override
    public String getMessage() {
        return Optional.ofNullable(super.getMessage()).orElseGet(errorCode::getDefaultErrorMessage);
    }

    public ErrorResponse getErrorResponse() {
        return new ErrorResponse(ErrorCode.INTERNAL_SERVER_EXCEPTION.getCode(), HttpStatus.INTERNAL_SERVER_ERROR, "Server failed to handle request");
    }

}
