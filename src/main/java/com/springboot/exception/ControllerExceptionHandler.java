package com.springboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ValidationException.class)
    Error exceptionHandler(ValidationException e) {
        List<String> errors = new ArrayList<>();
        errors.add(e.getMessage());
        return new Error(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.name(), errors);
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    Error exceptionHandler(ConstraintViolationException e) {
        List<String> errors = new ArrayList<>();
        errors.add(e.getMessage());
        return new Error(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.name(), errors);
    }

}