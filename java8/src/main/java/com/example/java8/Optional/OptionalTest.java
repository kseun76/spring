package com.example.java8.Optional;

import java.util.Optional;

public class OptionalTest {
    public static void main(String[] args) {
        String name = "John";

        // 1. Optional 을 사용하지 않는 예전
        // 값이 있을 경우
        System.out.println("Optional 사용하지 않는 소스");
        if (name != null) {
            System.out.println("Name: " + name);
        }

        // 값이 없을 경우
        String defaultName = "Unknown";
        String result = (name != null) ? name : defaultName;
        System.out.println("Result: " + result);

        System.out.println("========================================");
        System.out.println("Optional 사용한 소스");

        // 2. Optional 을 사용한 경우
        // 값이 있을 경우
        Optional<String> optionalName = Optional.ofNullable(name);
        optionalName.ifPresent(n -> System.out.println("Name: " + n));

        // 값이 없을 경우
        defaultName = "Unknown";
        result = optionalName.orElse(defaultName);
        System.out.println("Result: " + result);
    }
}
