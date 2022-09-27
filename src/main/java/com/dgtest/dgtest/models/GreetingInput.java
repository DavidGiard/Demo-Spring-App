package com.dgtest.dgtest.models;
public class GreetingInput {
    public GreetingInput(String personName) {
        this.personName = personName;
    }
    public GreetingInput() {
    }

    private String personName;
    public String getPersonName() {
        return personName;
    }
    public void setPersonName(String personName) {
        this.personName = personName;
    }
}
