package com.example.java8.Function;

import java.util.function.BiFunction;

public class BiFuncationTest {
    public static void main(String[] args) {

        // 람다를 이용한 방식 1
        /*
        BiFunction<String, String, String> addString = (s1, s2) -> {
            return s1.concat(s2);
        };
        */

        // 람다를 이용한 방식 2 (간략)
        BiFunction<String, String, String> addString = (s1, s2) -> s1.concat(s2);
        System.out.println("addString : " + addString.apply("ABC", "DEF"));
    }
}
