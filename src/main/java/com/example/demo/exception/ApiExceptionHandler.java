package com.example.demo.exception;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@Slf4j
public class ApiExceptionHandler  extends ResponseEntityExceptionHandler {

   // there more method needs to override if we want consistent behaviour across all the errors
    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
                                                                         HttpHeaders headers,
                                                                         HttpStatus status,
                                                                         WebRequest request) {

        ErrorResponse errorResponse = new ErrorResponse(ErrorCode.INVALID_HTTP_METHOD.getCode(),
                HttpStatus.BAD_REQUEST, "Request method '" + ex.getMethod() + "' not supported");
        return handleExceptionInternal(ex, errorResponse, headers, status, request);

    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<ErrorResponse> handleThrowable(Throwable e) {
        log.error(e.getMessage(), e);
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, ErrorCode.INTERNAL_SERVER_EXCEPTION);
        return buildResponseEntity(errorResponse);
    }

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<ErrorResponse> handleNotFoundException(BaseException exception) {
        return buildResponseEntity(exception.getErrorResponse());
    }

    private ResponseEntity<ErrorResponse> buildResponseEntity(ErrorResponse apiError) {
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }
}
