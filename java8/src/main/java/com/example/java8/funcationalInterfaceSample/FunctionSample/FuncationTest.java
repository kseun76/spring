package com.example.java8.funcationalInterfaceSample.FunctionSample;

import java.util.function.Function;

public class FuncationTest {
    public static void main(String[] args) {

        // 클래스를 이용한 방식
        /*
        AddPlus addPlus = new AddPlus();
        System.out.println("addPlus : " + addPlus.apply(10));
        */

        // 람다를 이용한 방식 1
        /*
        Function<Integer, Integer> addPlusLambda = (i) -> {
            return i + 100;
        };
        System.out.println("addPlus : " + addPlusLambda.apply(10));
        */

        // 람다를 이용한 방식 2 (간략하게)
        Function<Integer, Integer>  addPlusLambda = i -> i+100;
        System.out.println("addPlus : " + addPlusLambda.apply(10));
    }
}
