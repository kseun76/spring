package com.example.java8.CompletableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureExceptionTest {
    public static void main(String[] args) {

        // exceptionally 예제
        /*
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            String text = "Hello";
            if (text.equals("Hello")) {
                throw new IllegalArgumentException("Hello 문자열이 맞으면 에러발생");
            }
            return text;
        });

        // 예외 처리와 대체 값 반환
        CompletableFuture<String> handledFuture = future.exceptionally(ex -> {
            System.out.println("Exception occurred: " + ex.getMessage());
            return "World!"; // 에러 발생 시 "World!" 문자열 반환
        });

        try {
            String result = handledFuture.get();
            System.out.println("Result: " + result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        */

        // handle 예제
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            // 예외를 발생시키는 작업
            String text = "Hello";
            if (text.equals("Hello")) {
                throw new IllegalArgumentException("Hello 문자열이 맞으면 에러발생");
            }
            return text;
        });

        // 예외 처리와 결과 처리를 동시에 수행하는 handle 메서드
        CompletableFuture<String> handledFuture = future.handle((result, ex) -> {
            if (ex != null) {
                System.out.println("Exception occurred: " + ex.getMessage());
                return "World"; // World 문자열 반환
            }
            return result;
        });

        try {
            String result = handledFuture.get();
            System.out.println("Result: " + result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
