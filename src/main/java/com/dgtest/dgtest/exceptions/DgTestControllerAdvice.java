package com.dgtest.dgtest.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.dgtest.dgtest.models.MathOutput;

@ControllerAdvice
public class DgTestControllerAdvice {

    @ExceptionHandler(ArithmeticException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    MathOutput handleArithmeticException(ArithmeticException ex) {
        String message = "Math error: " + ex.getMessage();
        MathOutput mathOutput = new MathOutput(null, message);
        return mathOutput;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    String handleException(Exception ex) {
        String message = "Error: " + ex.getMessage();
        return message;
    }
}
