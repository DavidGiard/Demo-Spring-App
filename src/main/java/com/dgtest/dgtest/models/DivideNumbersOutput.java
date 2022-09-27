package com.dgtest.dgtest.models;

public class DivideNumbersOutput {
    private Integer quotient;
    private String message;

    public Integer getQuotient() {
        return quotient;
    }
    public void setQuotient(Integer quotient) {
        this.quotient = quotient;
    }

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    public DivideNumbersOutput(Integer quotient, String message) {
        super();
        this.quotient = quotient;
        this.message = message;
    }
}
