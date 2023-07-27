package com.example.java8.Lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {
    public static void main(String[] args) {
        List<String> itemNames = new ArrayList<>();

        itemNames.add("Aaaaa");
        itemNames.add("Bbbbb");
        itemNames.add("Ccccc");

        /*
        Stream<String> itemStream = itemNames.stream().map(String::toUpperCase);

        itemNames.forEach(System.out::println);

        itemStream.forEach((o) -> {
            System.out.println("itemStream: " + o);
        });
         */

        // B로 시작하는 String을 대문자로 바꾸서 출력하는 예제
        // 기존 처리 방식
        for(String itemName : itemNames) {
            if(itemName.startsWith("B")) {
                System.out.println(itemName.toUpperCase());
            }
        }

        System.out.println("========================");

        // Stream 사용 예제
        List<String> itemCollect = itemNames.stream()
                .filter(i -> i.startsWith("B")).map(String::toUpperCase)
                .collect(Collectors.toList());

        itemCollect.forEach(System.out::println);
    }
}
