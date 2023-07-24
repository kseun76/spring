package com.example.java8.Lambda;

public class ShadowingTest {
    private int x = 10; // 필드 x

    public static void main(String[] args) {
        ShadowingTest shadowingTest = new ShadowingTest();
        shadowingTest.shadowing();
    }

    private void shadowing() {
        int x = 20;
        System.out.println("shadowing :" + x); // 20
    }
}
