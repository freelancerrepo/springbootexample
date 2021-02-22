package com.springboot.exception;


import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class MethodArgumentNotValidExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Error handleInvalidMethodArgumentException(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();
        List<String> errors = new ArrayList<>();
        bindingResult.getFieldErrors().forEach(fE -> errors.add(fE.getObjectName() + "." + fE.getField() + "." + fE.getDefaultMessage()));
        bindingResult.getGlobalErrors().forEach(fE -> errors.add(fE.getObjectName() + "." + fE.getDefaultMessage()));
        return new Error(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.name(), errors);
    }
}
