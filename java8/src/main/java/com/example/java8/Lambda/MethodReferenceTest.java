package com.example.java8.Lambda;

import java.util.function.Function;

public class MethodReferenceTest {



    public static void main(String[] args) {
        // 람다
        Function<String, String> item = itemName -> "test" + itemName;
        System.out.println("Lambda : " + item.apply("11111"));

        // 스태틱 메소드 참조
        Function<String, String> item2 = Item::addString2;
        System.out.println(item2.apply("22222"));

    }

}
