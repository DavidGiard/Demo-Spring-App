package com.dgtest.dgtest.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("greetings")
@RestController
public class GreetingsController {

    @GetMapping("greet")
    public String greet() {
        return "Hello";
    }
}
