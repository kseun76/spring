package com.example.java8.Lambda;

public class Item {
    private String itemName;

    // 인자가 없는 생성자
    public Item() {

    }

    // itemName 받는 생성자
    public Item(String itemName) {
        this.itemName = itemName;
    }

    // itemName 문자열 추가
    public String addString1(String itemName) {
        return "NonStatic Method :" + itemName;
    }

    // static itemName 문자열 추가
    public static String addString2(String itemName) {
        return "Static Method : " + itemName;
    }
}
