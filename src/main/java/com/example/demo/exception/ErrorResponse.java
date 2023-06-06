package com.example.demo.exception;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.Instant;

/**
 * This class should be in sync in all 3 RP micro-services - Core, CA and User Config, as we wish to give uniform
 * response to the user.
 */
@Getter
@NoArgsConstructor
public class ErrorResponse {

    @JsonProperty("code")
    private int errorCode;

    @JsonIgnore
    private HttpStatus status;

    @JsonProperty("message")
    private String errorMessage;

    @JsonIgnore
    private Instant timestamp = Instant.now();


    public ErrorResponse( final HttpStatus status, final ErrorCode errorCodes ) {

        this.errorCode = errorCodes.getCode();
        this.status = status;
        this.errorMessage = errorCodes.getDefaultErrorMessage();
    }

    public ErrorResponse(final int errorCode,
                         final HttpStatus status,
                         final String errorMessage) {

        this.errorCode = errorCode;
        this.status = status;
        this.errorMessage = errorMessage;
    }

}