package com.example.java8.Lambda;

import java.util.function.Function;

public class LambdaTest {
    public static void main(String[] args) {
    Function<Integer, Integer> addPlus = (i) -> {
        return i + 100;
    };

    // 괄호, return 생략 가능
    Function<Integer, Integer> addPlus2 = (i) -> i+100;

    System.out.println("addPlus :" + addPlus.apply(10));
    System.out.println("addPlus2 :" + addPlus2.apply(10));
    }
}
