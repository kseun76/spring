package com.example.java8.CompletableFuture;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorsTest {
    public static void main(String[] args) {

        /*
        // 단일 스레드로 구성된 스레드 풀 생성
        ExecutorService executor = Executors.newSingleThreadExecutor();

        // 작업 실행
        executor.execute(() -> {
            System.out.println("Task - Start");
            try {
                Thread.sleep(1000); // 일부러 1초 대기
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Task - End");
        });

        // 스레드 풀 종료
        executor.shutdown();
         */

        // 두 개의 스레드로 구성된 스레드 풀 생성
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(2);

        // 작업 실행
        fixedThreadPool.execute(() -> {
            System.out.println("Fixed Thread Pool - Task 1 - Start");
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Fixed Thread Pool - Task 1 - End");
        });

        fixedThreadPool.execute(() -> {
            System.out.println("Fixed Thread Pool - Task 2 - Start");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Fixed Thread Pool - Task 2 - End");
        });

        // 두 개의 스레드 풀 종료
        fixedThreadPool.shutdown();

    }
}
