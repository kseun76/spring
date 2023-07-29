package com.example.java8.CompletableFuture;

public class TreadRunnableTest {
    public static void main(String[] args) {

        // 람다를 사용하지 않고 익명 클래스로 처리
        Runnable myRunnable1 = new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 5; i++) {
                    System.out.println(Thread.currentThread().getName() + " - Count: " + i);
                    try {
                        Thread.sleep(1000); // 1초 동안 일시 정지
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        // Runnable을 람다 표현식으로 처리
        Runnable myRunnable2 = () -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName() + " - Count: " + i);
                try {
                    Thread.sleep(1000); // 1초 동안 일시 정지
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        // 쓰레드 생성
        Thread thread1 = new Thread(myRunnable1, "Thread 1");
        Thread thread2 = new Thread(myRunnable2, "Thread 2");

        // 쓰레드 실행
        thread1.start();
        thread2.start();

        try {
            // main 쓰레드가 thread1과 thread2의 작업이 끝날 때까지 기다림
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All threads have finished.");
    }
}
