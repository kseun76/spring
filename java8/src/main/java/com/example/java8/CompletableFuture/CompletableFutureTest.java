package com.example.java8.CompletableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureTest {
    public static void main(String[] args) {
        /*
        // 비동기 작업 생성 및 실행
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            int num = 5;
            return num * num;
        });

        // 작업 완료 후 결과 처리
        future.thenAccept(result -> {
            System.out.println("Result: " + result);
        });
         */

        // 고정된 스레드 풀 생성
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        // 첫 번째 비동기 작업 생성 및 실행
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            return "Hello, ";
        }, executorService);

        // 두 번째 비동기 작업 생성 및 실행
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            return "world!";
        }, executorService);

        // 두 작업의 결과를 합쳐서 출력하는 비동기 작업 생성
        CompletableFuture<Void> combinedFuture = future1.thenCombine(future2, (result1, result2) -> {
            String combinedResult = result1 + result2;
            System.out.println("문자열 결과값 : " + combinedResult);
            return null; // CompletableFuture<Void>를 반환
        });

        try {
            // 비동기 작업 완료 대기
            combinedFuture.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            // 스레드 풀 종료
            executorService.shutdown();
        }
    }
}
