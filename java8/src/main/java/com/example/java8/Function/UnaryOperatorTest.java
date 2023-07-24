package com.example.java8.Function;
import java.util.function.UnaryOperator;

public class UnaryOperatorTest {
    public static void main(String[] args) {
        UnaryOperator<Integer> addPlus = (i) -> i + 100;
        System.out.println("addPlus : " + addPlus.apply(10));
    }
}
