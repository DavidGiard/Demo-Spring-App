package com.dgtest.dgtest.controllers;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dgtest.dgtest.exceptions.MissingArgumentsException;
import com.dgtest.dgtest.models.AddNumbersInput;
import com.dgtest.dgtest.models.AddNumbersOutput;
import com.dgtest.dgtest.models.DivideNumbersInput;
import com.dgtest.dgtest.models.DivideNumbersOutput;
import com.dgtest.dgtest.services.MathService;

@RequestMapping("math")
@RestController
public class MathController {

    private Logger logger = LoggerFactory.getLogger(MathController.class);

    @Autowired
    @Qualifier("MathServiceImpl")
    private MathService mathService;

    @GetMapping("add/{firstNumber}/{secondNumber}")
    public ResponseEntity<Integer> Add(
        @PathVariable("firstNumber") Integer firstNumber, 
        @PathVariable("secondNumber") Integer secondNumber,
        HttpServletRequest request) throws MissingArgumentsException {
            String requestKey = request.getHeader("X-Request-Key");
            if (requestKey == null) {
                requestKey = UUID.randomUUID().toString();
            }
            MDC.put("Request-Key", requestKey);
            logger.info("MathController.Add() called with " + firstNumber + " and " + secondNumber);

            Integer sum = mathService.AddNumbers(firstNumber, secondNumber);

            HttpHeaders responseHeaders = new HttpHeaders();
            responseHeaders.set("X-Request-Key", requestKey);
            return new ResponseEntity<Integer>(sum, responseHeaders, HttpStatus.OK);
    }

    @GetMapping("subtract/{firstNumber}/{secondNumber}")
    public ResponseEntity<Integer> subtract(
        @PathVariable("firstNumber") Integer firstNumber, 
        @PathVariable("secondNumber") Integer secondNumber) {
            Integer difference = mathService.SubtractNumbers(firstNumber, secondNumber);
            return new ResponseEntity<Integer>(difference, HttpStatus.OK);
    }

    @PostMapping(path="AddNumbers", consumes = "application/json", produces = "application/json")
    public ResponseEntity<AddNumbersOutput> AddNumbersPost(@RequestBody AddNumbersInput input) throws MissingArgumentsException {
        Integer firstNumber = input.getFirstNumber();
        Integer secondNumber = input.getSecondNumber();
        String personName = input.getPersonName();

        Integer sum = null;
        try {
            sum = mathService.AddNumbers(firstNumber, secondNumber);
        } catch (Exception e) {
            String message = e.getMessage();
            AddNumbersOutput output = new AddNumbersOutput(null, message);
            return new ResponseEntity<AddNumbersOutput>(output, HttpStatus.BAD_REQUEST);
        }

        if (personName.compareTo("Bob")==0) {
            String message = "Bob is not welcome here";
            AddNumbersOutput output = new AddNumbersOutput(null, message);
            return new ResponseEntity<AddNumbersOutput>(output, HttpStatus.BAD_REQUEST);
        }

        String message = "The sum of " + firstNumber + " and " + secondNumber 
            + " is " + sum + ",  " + personName;
        AddNumbersOutput output = new AddNumbersOutput(sum, message);
        return new ResponseEntity<AddNumbersOutput>(output, HttpStatus.OK);
    }

    @PostMapping(path="DivideNumbers", consumes = "application/json", produces = "application/json")
    public ResponseEntity<DivideNumbersOutput> DivideNumbersPost(@RequestBody DivideNumbersInput input) throws MissingArgumentsException {
        Integer firstNumber = input.getFirstNumber();
        Integer secondNumber = input.getSecondNumber();
        String personName = input.getPersonName();
        Integer quotient = mathService.DivideNumbers(firstNumber, secondNumber);
        String message = firstNumber + " divided by " + secondNumber 
            + " is " + quotient + ", " + personName;
        DivideNumbersOutput output = new DivideNumbersOutput(quotient, message);
        return new ResponseEntity<DivideNumbersOutput>(output, HttpStatus.OK);
    }
}
