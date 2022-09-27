package com.dgtest.dgtest.models;

public class AddNumbersOutput {
    private Integer sum;
    private String message;

    public Integer getSum() {
        return sum;
    }
    public void setSum(Integer sum) {
        this.sum = sum;
    }

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    public AddNumbersOutput(Integer sum, String message) {
        super();
        this.sum = sum;
        this.message = message;
    }
}
