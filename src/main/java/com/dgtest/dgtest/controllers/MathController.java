package com.dgtest.dgtest.controllers;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        @PathVariable("secondNumber") Integer secondNumber) {

            String requestKey = UUID.randomUUID().toString();
            MDC.put("Request-Key", requestKey);
            logger.info("MathController.Add() called with " + firstNumber + " and " + secondNumber);

            Integer sum = mathService.AddNumbers(firstNumber, secondNumber);
            return new ResponseEntity<Integer>(sum, HttpStatus.OK);
    }

    @GetMapping("subtract/{firstNumber}/{secondNumber}")
    public ResponseEntity<Integer> subtract(
        @PathVariable("firstNumber") Integer firstNumber, 
        @PathVariable("secondNumber") Integer secondNumber) {
            Integer difference = mathService.SubtractNumbers(firstNumber, secondNumber);
            return new ResponseEntity<Integer>(difference, HttpStatus.OK);
    }
}
