package com.dgtest.models;
public class GreetingOutput {
    public GreetingOutput(String greeting) {
        this.greeting = greeting;
    }
    public GreetingOutput() {
    }

    private String greeting;
    public String getGreeting() {
        return greeting;
    }
    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }
}
