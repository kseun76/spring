package com.example.java8.Optional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalPrincipleTest {
    public static void main(String[] args) {

        // Sample 1: Optional은 반환 타입으로만 사용하세요
        Optional<String> optionalName1 = getName();
        optionalName1.ifPresent(name -> System.out.println("Sample 1 - Name: " + name));

        // Sample 2: get() 메서드를 사용할 때 주의
        Optional<String> optionalName2 = Optional.ofNullable(null);
        // 아래 주석을 해제하면 NoSuchElementException 발생
        // String name2 = optionalName2.get();

        // Sample 3: orElse() 대신 orElseGet() 사용 권장
        Optional<String> optionalName3 = Optional.empty();
        String result3_1 = optionalName3.orElse(getDefaultValue());
        System.out.println("Sample 3 - Result with orElse: " + result3_1);

        String result3_2 = optionalName3.orElseGet(OptionalPrincipleTest::getDefaultValue);
        System.out.println("Sample 3 - Result with orElseGet: " + result3_2);

        // Sample 4: ifPresent()로 조건 처리
        Optional<String> optionalName4 = Optional.ofNullable("John");
        optionalName4.ifPresent(name -> System.out.println("Sample 4 - Hello, " + name));

        // Sample 5: 스트림에서 Optional 사용 주의
        List<String> names = Arrays.asList("John", "Jane", null, "Michael", null, "Emily");

        // Optional 사용하는 경우
        // filter로 null 을 제거했는데 opt.ifPresent 또 사용하고 있다.
        names.stream()
                .filter(name -> name != null)
                .map(Optional::ofNullable)
                .forEach(opt -> opt.ifPresent(name -> System.out.println("Sample 5 - Hello, " + name)));

        // Sample 6: 너무 지나치게 사용하지 말 것
        //이미 name6 변수에는 null이 아닌 값이 들어가 있기 때문에 ofNullable()을 사용할 필요가 없다.
        //대신 Optional.of() 메서드를 사용하면 된다
        String name6 = "John";
        Optional<String> optionalName6 = Optional.ofNullable(name6);
        optionalName6.ifPresent(n -> System.out.println("Sample 6 - Name: " + n));

        // defaultName6 기본값 생성이 항상 실행됨: orElse() 메서드는 항상 기본값을 생성합니다.
        // 즉, optionalName6이 값이 있더라도 항상 defaultName6 을 생성하는 연산을 수행합니다.
        // 이러한 문제를 해결하기 위해서는 orElseGet() 메서드를 사용해야 합니다.
        String defaultName6 = "Unknown";
        String result6 = optionalName6.orElse(defaultName6);
        System.out.println("Sample 6 - Result: " + result6);
    }

    private static Optional<String> getName() {
        String name = "John";
        return Optional.ofNullable(name);
    }

    private static String getDefaultValue() {
        System.out.println("Generating default value...");
        return "Unknown";
    }
}
