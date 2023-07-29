package com.example.java8.Stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamIntermediateTest {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<String> fruits = Arrays.asList("apple", "orange", "banana", "grape");

        // filter - 짝수만 선택
        List<Integer> evenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());

        System.out.println("Even numbers: " + evenNumbers); // 출력: Even numbers: [2, 4, 6, 8, 10]

        // map - 이름 길이로 변환
        List<Integer> nameLengths = fruits.stream()
                .map(String::length)
                .collect(Collectors.toList());

        System.out.println("Name lengths: " + nameLengths); // 출력: Name lengths: [5, 6, 6, 5]

        // sorted - 정렬
        List<String> sortedFruits = fruits.stream()
                .sorted()
                .collect(Collectors.toList());

        System.out.println("Sorted fruits: " + sortedFruits); // 출력: Sorted fruits: [apple, banana, grape, orange]

        // distinct - 중복 제거
        List<Integer> distinctNumbers = numbers.stream()
                .distinct()
                .collect(Collectors.toList());

        System.out.println("Distinct numbers: " + distinctNumbers); // 출력: Distinct numbers: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

        // limit와 skip - 일부 요소 선택 및 건너뛰기
        List<Integer> limitedNumbers = numbers.stream()
                .limit(5) // 처음 5개의 요소만 선택
                .collect(Collectors.toList());

        List<Integer> skippedNumbers = numbers.stream()
                .skip(5) // 처음 5개의 요소를 건너뜀
                .collect(Collectors.toList());

        System.out.println("Limited numbers: " + limitedNumbers); // 출력: Limited numbers: [1, 2, 3, 4, 5]
        System.out.println("Skipped numbers: " + skippedNumbers); // 출력: Skipped numbers: [6, 7, 8, 9, 10]
    }
}
