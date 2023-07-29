package com.example.java8.DateTime;

import java.time.*;

public class DateTimeAfterJava8Test {
    public static void main(String[] args) {

        // LocalDate 예제: 현재 날짜를 가져옴
        LocalDate currentDate = LocalDate.now();
        System.out.println("Current Date: " + currentDate);
        // 결과: Current Date: 2023-07-29

        // LocalTime 예제: 현재 시간을 가져옴
        LocalTime currentTime = LocalTime.now();
        System.out.println("Current Time: " + currentTime);
        // 결과: Current Time: 14:30:15.123456789

        // LocalDateTime 예제: 현재 날짜와 시간을 가져옴
        LocalDateTime currentDateTime = LocalDateTime.now();
        System.out.println("Current Date and Time: " + currentDateTime);
        // 결과: Current Date and Time: 2023-07-29T14:30:15.123456789

        // ZonedDateTime 예제: 특정 시간대를 고려한 날짜와 시간을 가져옴
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println("Zoned Date and Time: " + zonedDateTime);
        // 결과: Zoned Date and Time: 2023-07-29T14:30:15.123456789+09:00[Asia/Seoul]

        // Instant 예제: 에포크 시간(1970년 1월 1일 0시 0분 0초)부터의 경과 시간을 가져옴
        Instant instant = Instant.now();
        System.out.println("Instant: " + instant);
        // 결과: Instant: 2023-07-29T05:30:15.123456789Z

        // Duration 예제: 두 시간 사이의 차이를 계산
        LocalDateTime startDateTime = LocalDateTime.of(2023, 7, 28, 10, 0);
        LocalDateTime endDateTime = LocalDateTime.of(2023, 7, 28, 12, 30);
        Duration duration = Duration.between(startDateTime, endDateTime);
        System.out.println("Duration: " + duration.toHours() + " hours and " +
                duration.toMinutes() + " minutes");
        // 결과: Duration: 2 hours and 30 minutes

        // Period 예제: 두 날짜 사이의 차이를 계산
        LocalDate startDate = LocalDate.of(2023, 7, 28);
        LocalDate endDate = LocalDate.of(2024, 7, 28);
        Period period = Period.between(startDate, endDate);
        System.out.println("Period: " + period.getYears() + " years, " +
                period.getMonths() + " months, and " +
                period.getDays() + " days");
        // 예상 결과: Period: 1 years, 0 months, and 0 days
    }
}