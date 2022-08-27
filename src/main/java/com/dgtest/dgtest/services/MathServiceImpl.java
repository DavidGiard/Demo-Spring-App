package com.dgtest.dgtest.services;

public class MathServiceImpl implements MathService {

    @Override
    public Integer AddNumbers(Integer firstNumber, Integer secondNumber) {
        Integer sum = firstNumber + secondNumber;
        return sum;
    }

    @Override
    public Integer SubtractNumbers(Integer firstNumber, Integer secondNumber) {
        Integer difference = firstNumber - secondNumber;
        return difference;
    }
}
