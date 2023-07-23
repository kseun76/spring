package com.example.java8.funcationalInterfaceSample.FunctionSample;
import java.util.function.Supplier;

public class SupplierTest {
    public static void main(String[] args) {

        // 람다를 이용한 방식 1
        /*
        Supplier<String> printString = () -> {
            return "supplier print";
        };
        System.out.println("Supplier Test:" + printString.get());
        */

        // 람다를 이용한 방식 2 (간략)
        Supplier<String> printString = () -> "supplier print";
        System.out.println("Supplier Test:" + printString.get());
    }
}
