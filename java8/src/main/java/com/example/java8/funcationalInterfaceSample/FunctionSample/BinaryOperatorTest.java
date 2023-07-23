package com.example.java8.funcationalInterfaceSample.FunctionSample;
import java.util.function.BinaryOperator;

public class BinaryOperatorTest {
    public static void main(String[] args) {
        BinaryOperator<Integer> addPlus = (i, j) -> i+j;
        System.out.println("addPlus : " + addPlus.apply(10, 20));
    }
}
