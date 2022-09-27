package com.dgtest.dgtest.models;

public class MathOutput {
    private Integer result;
    private String message;

    public Integer getQuotient() {
        return result;
    }
    public void setQuotient(Integer result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    public MathOutput(Integer result, String message) {
        super();
        this.result = result;
        this.message = message;
    }
}
