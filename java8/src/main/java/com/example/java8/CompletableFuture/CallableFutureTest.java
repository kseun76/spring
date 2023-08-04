package com.example.java8.CompletableFuture;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableFutureTest {
    public static void main(String[] args) {
        // ExecutorService를 생성하여 스레드 풀을 관리합니다.
        ExecutorService executor = Executors.newFixedThreadPool(2);

        // Callable을 구현한 객체를 생성합니다.
        Callable<Integer> task1 = () -> {
            Thread.sleep(1000); // 1초 대기
            return 100;
        };

        Callable<Integer> task2 = () -> {
            Thread.sleep(2000); // 2초 대기
            return 200;
        };

        // Callable을 스레드 풀에 제출하고 Future를 받아옵니다.
        Future<Integer> future1 = executor.submit(task1);
        Future<Integer> future2 = executor.submit(task2);

        // isDone() 메서드를 사용하여 작업이 완료되었는지 확인합니다.
        while (!future1.isDone() && !future2.isDone()) {
            System.out.println("Task 1과 Task 2가 진행 중입니다.");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // 작업이 완료되었을 때, 결과를 얻습니다.
        try {
            if (future1.isDone()) {
                int result1 = future1.get();
                System.out.println("Task 1 결과: " + result1);
            } else {
                future1.cancel(true);
                System.out.println("Task 1이 취소되었습니다.");
            }

            if (future2.isDone()) {
                int result2 = future2.get();
                System.out.println("Task 2 결과: " + result2);
            } else {
                future2.cancel(true);
                System.out.println("Task 2가 취소되었습니다.");
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        // 스레드 풀 종료
        executor.shutdown();
    }
}
