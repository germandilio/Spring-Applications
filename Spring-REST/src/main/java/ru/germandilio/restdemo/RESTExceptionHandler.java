package ru.germandilio.restdemo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import ru.germandilio.restdemo.errors.StudentErrorResponse;
import ru.germandilio.restdemo.errors.StudentNotFoundException;

@ControllerAdvice
public class RESTExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleStudentNotFound(StudentNotFoundException ex) {
        return new ResponseEntity<>(new StudentErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage(), System.currentTimeMillis()),
                HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleStudentParamTypeMismatch(MethodArgumentTypeMismatchException ex) {
        return new ResponseEntity<>(new StudentErrorResponse(HttpStatus.EXPECTATION_FAILED.value(), ex.getMessage(), System.currentTimeMillis()),
                HttpStatus.EXPECTATION_FAILED);
    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleStudentGeneralExceptions(Exception ex) {
        return new ResponseEntity<>(new StudentErrorResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage(), System.currentTimeMillis()),
                HttpStatus.BAD_REQUEST);
    }
}
