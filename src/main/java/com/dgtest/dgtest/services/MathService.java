package com.dgtest.dgtest.services;

import com.exceptions.MissingArgumentsException;

public interface MathService {
    Integer AddNumbers(Integer firstNumber, Integer secondNumber) throws MissingArgumentsException;
    Integer SubtractNumbers(Integer firstNumber, Integer secondNumber);
}
