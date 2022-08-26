package com.dgtest.dgtest.controllers;

import org.springframework.boot.autoconfigure.dao.PersistenceExceptionTranslationAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
