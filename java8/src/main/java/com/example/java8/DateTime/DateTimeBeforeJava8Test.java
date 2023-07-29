package com.example.java8.DateTime;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateTimeBeforeJava8Test {
    public static void main(String[] args) {
        // 1. 가독성과 유지보수 어려움
        // Date 클래스는 지루한 API로 가독성이 떨어짐
        // Calendar 클래스에서 월은 0부터 시작하는 인덱스로 표현되어 혼란스러움

        // 현재 시간 구하기 (Date 클래스)
        Date currentDate = new Date();
        System.out.println("Current Date (Before Java 8): " + currentDate);

        // 2. 가변성(mutability)
        // Date 클래스는 가변(mutable) 클래스로 설계되어 있어 객체의 상태를 변경할 수 있음
        // 멀티스레드 환경에서 안전하지 않음
        // 현재 시간 구하기 (Date 클래스)

        long timeInMillis = currentDate.getTime();
        timeInMillis += 1000 * 60 * 60; // 1시간(밀리초 단위) 추가
        currentDate.setTime(timeInMillis);
        System.out.println("Modified Date (Before Java 8): " + currentDate);

        // 1주일 후 구하기 (Calendar 클래스)
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        calendar.add(Calendar.WEEK_OF_YEAR, 1);
        Date oneWeekLater = calendar.getTime();
        System.out.println("One Week Later (Before Java 8): " + oneWeekLater);

        // GregorianCalendar 클래스
        GregorianCalendar gregorianCalendar = new GregorianCalendar(2023, Calendar.JULY, 28, 12, 30, 45);
        System.out.println("GregorianCalendar (Before Java 8): " + gregorianCalendar.getTime());

        // 3. 월(Month) 표현의 문제
        // Calendar 클래스에서 월은 0부터 시작하는 인덱스로 표현되어 혼란스러움
        int month = calendar.get(Calendar.MONTH) + 1; // 0부터 시작하므로 1을 더해야 실제 월 표현
        System.out.println("Month (Before Java 8): " + month);

        // 4. 자료형의 한계
        // Date 클래스는 밀리초 단위의 시간만 표현할 수 있고, 날짜와 시간을 분리할 수 없음
        // 시간대(time zone)와 같은 개념을 다루기 어려움

        // 현재 시간 구하기 (Date 클래스)
        Date currentDate2 = new Date();
        System.out.println("Current Date (Before Java 8): " + currentDate2);

        // Date에서 연도, 월, 일 추출하기 (자료형의 한계로 인해 복잡하고 불편함)
        int year = currentDate2.getYear() + 1900; // 1900을 더해야 실제 연도 값
        int month2 = currentDate2.getMonth() + 1; // 0부터 시작하므로 1을 더해야 실제 월 값
        int day = currentDate2.getDate();
        System.out.println("Year: " + year + ", Month: " + month2 + ", Day: " + day);

        // 5. Date와 Calendar의 불일치
        // Date 클래스는 날짜와 시간을 동시에 다루기 때문에 Date의 인스턴스는 날짜 정보와 시간 정보가 함께 포함되어 있음
        // Calendar 클래스는 날짜와 시간 정보를 별도로 다루기 때문에 연관된 메서드들이 서로 다른 클래스에 분산되어 있음

        // 현재 시간 구하기 (Date 클래스)
        Date currentDate3 = new Date();
        System.out.println("Current Date (Before Java 8): " + currentDate3);

        // Date를 Calendar로 변환하여 연도와 월, 일 따로 구하기
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(currentDate3);
        int year2 = calendar2.get(Calendar.YEAR);
        int month3 = calendar2.get(Calendar.MONTH) + 1; // 0부터 시작하므로 1을 더해야 실제 월 값
        int day2 = calendar2.get(Calendar.DAY_OF_MONTH);
        System.out.println("Year: " + year2 + ", Month: " + month3 + ", Day: " + day2);

        // Calendar 클래스를 사용하여 연도, 월, 일을 구하려면 번거로운 과정이 필요함
        // Date와 Calendar를 혼용하여 사용하면 코드의 일관성이 떨어지고 혼동을 유발할 수 있음
    }
}
