package ru.germandilio.springcrm.controllers.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllersExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<ServerResponse> handleException(CustomerNotFoundException ex) {
        return new ResponseEntity<>(new ServerResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage(), System.currentTimeMillis()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ServerResponse> handleParamTypeMismatchException(Exception ex) {
        return new ResponseEntity<>(new ServerResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage(), System.currentTimeMillis()), HttpStatus.BAD_REQUEST);
    }
}
