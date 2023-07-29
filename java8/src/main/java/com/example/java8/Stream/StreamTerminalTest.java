package com.example.java8.Stream;

import java.util.Arrays;
import java.util.List;

public class StreamTerminalTest {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // count - 스트림의 요소 개수를 반환
        long count = numbers.stream().count();
        System.out.println("Count: " + count); // 출력: Count: 10

        // forEach - 각 요소를 출력
        System.out.print("Numbers: ");
        numbers.stream().forEach(n -> System.out.print(n + " ")); // 출력: Numbers: 1 2 3 4 5 6 7 8 9 10
        System.out.println();

        // reduce - 스트림의 요소들을 하나로 합치거나 연산 결과를 반환
        int sum = numbers.stream().reduce(0, Integer::sum);
        System.out.println("Sum: " + sum); // 출력: Sum: 55

        // anyMatch - 조건에 맞는 요소가 하나라도 있는지 검사
        boolean hasEvenNumber = numbers.stream().anyMatch(n -> n % 2 == 0);
        System.out.println("Has even number: " + hasEvenNumber); // 출력: Has even number: true

        // allMatch - 모든 요소가 조건에 맞는지 검사
        boolean allGreaterThanZero = numbers.stream().allMatch(n -> n > 0);
        System.out.println("All greater than zero: " + allGreaterThanZero); // 출력: All greater than zero: true

        // noneMatch - 조건에 맞는 요소가 없는지 검사
        boolean noneGreaterThanTen = numbers.stream().noneMatch(n -> n > 10);
        System.out.println("None greater than ten: " + noneGreaterThanTen); // 출력: None greater than ten: true
    }
}
