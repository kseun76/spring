package com.example.java8.funcationalInterfaceSample.FunctionSample;
import java.util.function.Consumer;

public class ConsumerTest {
    public static void main(String[] args) {

        // 람다를 이용한 방식 1
        /*
        Consumer<String> printString = (text) -> {
            System.out.println("s1 print" + text);
        };
        printString.accept("ConsumerTest");
        */

        // 람다를 이용한 방식 2 (간략)
        Consumer<String> printString = (text) -> System.out.println(text);
        printString.accept("ConsumerTest");
    }
}
