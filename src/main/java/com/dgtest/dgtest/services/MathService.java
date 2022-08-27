package com.dgtest.dgtest.services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

public interface MathService {
    Integer AddNumbers(Integer firstNumber, Integer secondNumber);
    Integer SubtractNumbers(Integer firstNumber, Integer secondNumber);
}
