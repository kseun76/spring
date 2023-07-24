package com.example.java8.Lambda;

import java.util.function.Supplier;

public class VariableCaptureTest {
    public static void main(String[] args) {

        /**
         * effective final variable
         * final int baseNumber = 100;
         * Java 8 부터 final 생략 가능
         */
        int baseNumber = 100;

        //로컬 클래스
        class LocalClass {
            int printBaseNumber(){
                return baseNumber;
            }
        }
        System.out.println("LocalClass:" + new LocalClass().printBaseNumber());

        //익명 클래스
        Supplier<Integer> AnonymousClass = new Supplier<Integer>() {
            @Override
            public Integer get() {
                return baseNumber;
            }
        };
        System.out.println("AnonymousClass:" + AnonymousClass.get());

        //람다
        Supplier<Integer> LambdaSupplier = () -> baseNumber;
        System.out.println("LambdaSupplier:" + LambdaSupplier.get());

    }
}
