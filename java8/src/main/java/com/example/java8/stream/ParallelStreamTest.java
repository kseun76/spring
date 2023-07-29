package com.example.java8.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ParallelStreamTest {
    public static void main(String[] args) {
        List<Integer> numberList = new ArrayList<>();
        for (int i = 1; i <= 1000000; i++) {
            numberList.add(i);
        }

        // 일반적인 스트림 처리
        long startTime = System.currentTimeMillis();
        long sum = numberList.stream()
                .reduce(0, Integer::sum);
        long endTime = System.currentTimeMillis();
        System.out.println("일반 스트림 처리 시간: " + (endTime - startTime) + "ms");
        System.out.println("결과: " + sum);

        System.out.println("=====================================");
        // 병렬 처리
        startTime = System.currentTimeMillis();
        long parallelSum = numberList.parallelStream()
                .reduce(0, Integer::sum);
        endTime = System.currentTimeMillis();
        System.out.println("병렬 스트림 처리 시간: " + (endTime - startTime) + "ms");
        System.out.println("결과: " + parallelSum);
    }
}
