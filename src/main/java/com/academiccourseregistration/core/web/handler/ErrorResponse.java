package com.academiccourseregistration.core.web.handler;

import java.beans.ConstructorProperties;
import java.time.Instant;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(of = {"status", "message"})
public class ErrorResponse {

    private final HttpStatus status;
    private final Instant timestamp;
    private final String message;
    private final String details;

    @ConstructorProperties({"code", "message", "details", "errorCode"})
    private ErrorResponse(HttpStatus status, String message, String details) {
        this.status = status;
        this.message = message;
        this.details = details;
        this.timestamp = Instant.now();
    }

    public static ErrorResponse of(HttpStatus status, String message) {
        return of(status, message, null);
    }

    public static ErrorResponse of(HttpStatus status, String message, String details) {
        return new ErrorResponse(status, message, details);
    }
}