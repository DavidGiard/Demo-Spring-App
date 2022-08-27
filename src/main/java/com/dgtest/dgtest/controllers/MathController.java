package com.dgtest.dgtest.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dgtest.dgtest.services.MathService;
import com.dgtest.dgtest.services.MathServiceImpl;

@RequestMapping("math")
@RestController
public class MathController {
    @GetMapping("add/{firstNumber}/{secondNumber}")
    public ResponseEntity<Integer> Add(
        @PathVariable("firstNumber") Integer firstNumber, 
        @PathVariable("secondNumber") Integer secondNumber) {
            MathService mathService = new MathServiceImpl();
            Integer sum = mathService.AddNumbers(firstNumber, secondNumber);
            return new ResponseEntity<Integer>(sum, HttpStatus.OK);
    }

    @GetMapping("subtract/{firstNumber}/{secondNumber}")
    public ResponseEntity<Integer> subtract(
        @PathVariable("firstNumber") Integer firstNumber, 
        @PathVariable("secondNumber") Integer secondNumber) {
            MathService mathService = new MathServiceImpl();
            Integer difference = mathService.SubtractNumbers(firstNumber, secondNumber);
            return new ResponseEntity<Integer>(difference, HttpStatus.OK);
    }
}
