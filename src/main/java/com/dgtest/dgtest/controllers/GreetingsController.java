package com.dgtest.dgtest.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dgtest.models.GreetingInput;
import com.dgtest.models.GreetingOutput;

@RequestMapping("greetings")
@RestController
public class GreetingsController {
    @GetMapping("greet")
    public ResponseEntity<String> greet() {
        return new ResponseEntity<String>("Hello", HttpStatus.OK);
    }

    @GetMapping("greet/{personName}")
    public ResponseEntity<String> greetPerson(@PathVariable("personName")String personName) {
        String greeting = "Hello, " + personName;
        return new ResponseEntity<String>(greeting, HttpStatus.OK);
    }

    @PostMapping(path="hello", consumes="application/json", produces="application/json")
    public ResponseEntity<GreetingOutput> greetPersonPost(@RequestBody GreetingInput greetingInput) {
        String personName = greetingInput.getPersonName();
        String greeting = "Hello, " + personName;
        GreetingOutput greetingOutput = new GreetingOutput(greeting);
        return new ResponseEntity<GreetingOutput>(greetingOutput, HttpStatus.OK);
    }
}
