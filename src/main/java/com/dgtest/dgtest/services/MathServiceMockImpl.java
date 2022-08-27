package com.dgtest.dgtest.services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Qualifier("MathServiceMockImpl")
@Service
public class MathServiceMockImpl implements MathService {
    @Override
    public Integer AddNumbers(Integer firstNumber, Integer secondNumber) {
        return 10;
    }

    @Override
    public Integer SubtractNumbers(Integer firstNumber, Integer secondNumber) {
        return 5;
    }
}
