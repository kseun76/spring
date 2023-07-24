package com.example.java8.Function;
import java.util.function.Predicate;

public class PredicateTest {
    public static void main(String[] args) {

        // test()
        Predicate<String> isTestString = s -> s.equals("find");
        System.out.println("isTestString test(aaa) -> " + isTestString.test("aaa"));  // false
        System.out.println("isTestString test(find) -> " + isTestString.test("find")); // true

        //and(), or()
        Predicate<Integer> isOdd = (i) -> i%2 == 0;
        Predicate<Integer> isEven = (i) -> i%2 == 1;
        System.out.println("isOdd and(2) -> " + isOdd.and(isEven).test(2));  //false
        System.out.println("isOdd or(2) -> " + isOdd.or(isEven).test(2));    //true

        //isEqual()
        Predicate<String> isStringEquals = Predicate.isEqual("aaa");
        Predicate<Integer> isNumEquals = Predicate.isEqual(10);
        System.out.println("isStringEquals isEqual(bbb) -> " + isStringEquals.test("bbb"));   //false
        System.out.println("isNumEquals isEqual(10) -> " +isNumEquals.test(10));             //true
    }
}
