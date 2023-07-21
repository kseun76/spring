package com.example.java8.funcationalInterfaceSample;

public class PureFunction {
    public static void main(String[] args) {

        //익명 내부 클래스로 구현
        /*
        RunPlus runPlus = new RunPlus() {
            @Override
            public int add(int number) {
                return number + 10;
            }
        };
        */

        // 람다 표현식
        RunPlus runPlus = (number) -> {
            return number + 10;
        };

        System.out.println(runPlus.add(1));
        System.out.println(runPlus.add(2));
        System.out.println(runPlus.add(3));
    }

}
