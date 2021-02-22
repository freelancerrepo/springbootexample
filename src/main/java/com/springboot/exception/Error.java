package com.springboot.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Error {

    private int errorCode;
    private String error;
    private List<String> fieldErrors;
}
