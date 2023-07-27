package com.example.java8.Lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;
public class MethodReferenceTest {
    public static void main(String[] args) {
        // 람다
        /*
        Function<String, String> item = (itemName) -> itemName;
        System.out.println("Lambda : " + item.apply("11111"));
        */
        // 스태틱 메소드 참조
        /*
        Function<String, String> item2 = Item::addString2;
        System.out.println(item2.apply("22222"));
        */

        //특정 객체의 메소드 참조
        /*
        Item item = new Item();
        Function<String, String> item3 = item::addString1;
        System.out.println(item3.apply("33333"));
         */

        // 생성자 참조 (인자가 있음)
        /*
        Function<String, Item> itemConstruct = Item::new;
        Item item4 = itemConstruct.apply("44444");
        System.out.println("Construct :" +item4.itemName);
         */

        String[] itemNames = {"AAAAA", "BBBBB", "CCCCC"};

        //기존의 익명클래스를 이용한 방법
        //배열을 정렬함에 있어서 sort 메서드를 사용할 수 있는데, 두 번째 인자로 Comparator를 받는다.
        Arrays.sort(itemNames, new Comparator<String>() {
            @Override
            public int compare(String s, String t1) {
                return 0;
            }
        });

        System.out.println("Sample1:" +Arrays.toString(itemNames));

        //람다 표현식
        //자바 8부턴 Comparator가 함수형 인터페이스로 바뀌게 되면서 익명 구현 객체 대신 람다 표현식을 사용할 수 있게 됐다
        Arrays.sort(itemNames, (s, t1) -> 0);
        System.out.println("Sample2:" +Arrays.toString(itemNames));

        //메소드 레퍼런스를 이용한 방법
        Arrays.sort(itemNames, String::compareToIgnoreCase);
        System.out.println("Sample3:" +Arrays.toString(itemNames));
    }
}
