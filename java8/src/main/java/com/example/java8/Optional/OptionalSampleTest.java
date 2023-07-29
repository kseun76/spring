package com.example.java8.Optional;

import java.util.Optional;

public class OptionalSampleTest {
    public static void main(String[] args) {
        // Sample data
        String name = "John";
        String nullName = null;

        // isPresent() - 값이 존재하는지 확인
        Optional<String> optionalName1 = Optional.ofNullable(name);
        System.out.println("isPresent() - optionalName1: " + optionalName1.isPresent()); // 출력: true

        Optional<String> optionalName2 = Optional.ofNullable(nullName);
        System.out.println("isPresent() - optionalName2: " + optionalName2.isPresent()); // 출력: false

        // get() - 값 가져오기 (주의: 값이 없는 경우 NoSuchElementException 발생)
        String value1 = optionalName1.get();
        System.out.println("get() - value1: " + value1); // 출력: John

        try {
            String value2 = optionalName2.get(); // NoSuchElementException 발생
            System.out.println("get() - value2: " + value2);
        } catch (Exception e) {
            System.out.println("get() - value2: NoSuchElementException");
        }

        // ifPresent() - 값이 존재할 때만 동작 수행
        optionalName1.ifPresent(n -> System.out.println("ifPresent() - Hello, " + n)); // 출력: Hello, John
        optionalName2.ifPresent(n -> System.out.println("ifPresent() - Hello, " + n)); // 동작하지 않음

        // orElse() - 값이 없을 때 기본값 반환
        String result1 = optionalName1.orElse("Unknown");
        System.out.println("orElse() - result1: " + result1); // 출력: John

        String result2 = optionalName2.orElse("Unknown");
        System.out.println("orElse() - result2: " + result2); // 출력: Unknown

        // orElseGet() - 값이 없을 때 Supplier로부터 기본값 가져오기
        String result3 = optionalName1.orElseGet(() -> "Default");
        System.out.println("orElseGet() - result3: " + result3); // 출력: John

        String result4 = optionalName2.orElseGet(() -> "Default");
        System.out.println("orElseGet() - result4: " + result4); // 출력: Default

        // orElseThrow() - 값이 없을 때 예외 던지기
        try {
            String result5 = optionalName1.orElseThrow(IllegalStateException::new);
            System.out.println("orElseThrow() - result5: " + result5);
        } catch (Exception e) {
            System.out.println("orElseThrow() - result5: IllegalStateException");
        }

        try {
            String result6 = optionalName2.orElseThrow(IllegalStateException::new); // IllegalStateException 발생
            System.out.println("orElseThrow() - result6: " + result6);
        } catch (Exception e) {
            System.out.println("orElseThrow() - result6: IllegalStateException");
        }

        // filter() - 값이 조건을 만족하는지 확인
        Optional<String> filteredName = optionalName1.filter(n -> n.startsWith("J"));
        System.out.println("filter() - filteredName: " + filteredName.orElse("None")); // 출력: John

        Optional<String> filteredName2 = optionalName1.filter(n -> n.startsWith("M"));
        System.out.println("filter() - filteredName2: " + filteredName2.orElse("None")); // 출력: None

        // map() - 값 변환
        Optional<String> upperCaseName = optionalName1.map(String::toUpperCase);
        System.out.println("map() - upperCaseName: " + upperCaseName.orElse("None")); // 출력: JOHN

        Optional<String> upperCaseName2 = optionalName2.map(String::toUpperCase);
        System.out.println("map() - upperCaseName2: " + upperCaseName2.orElse("None")); // 출력: None
    }
}
