package com.example.java8.funcationalInterfaceSample.FunctionSample;

import java.util.function.Function;

public class AddPlus implements Function<Integer, Integer> {
    @Override
    public Integer apply(Integer integer) {
        return integer + 100;
    }
}
