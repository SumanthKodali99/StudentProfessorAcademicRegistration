package com.academiccourseregistration.core.web.handler;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

import javax.persistence.EntityNotFoundException;

import org.hibernate.service.spi.ServiceException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class ExceptionCatcher {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorResponse> entityNotFound(EntityNotFoundException ex) {
        ErrorResponse error = ErrorResponse.of(NOT_FOUND, "Entity not found", ex.getMessage());
        log.warn("EntityNotFoundException was thrown", ex);
        return new ResponseEntity<>(error, NOT_FOUND);
    }

    @ExceptionHandler(ServiceException.class)
    public ResponseEntity<ErrorResponse> entityNotFound(ServiceException ex) {
        ErrorResponse error = ErrorResponse.of(BAD_REQUEST, ServiceException.class.getName(), ex.getMessage());
        log.warn("ServiceException was thrown", ex);
        return new ResponseEntity<>(error, BAD_REQUEST);
    }
}