# [문자열을 정수로 바꾸기](https://school.programmers.co.kr/learn/courses/30/lessons/12925)

## 📌 문제 설명
문자열 s를 숫자로 변환한 결과를 반환하는 함수, solution을 완성하세요.

### 제한사항

- s의 길이는 1 이상 5이하입니다.
- s의 맨앞에는 부호(+, -)가 올 수 있습니다.
- s는 부호와 숫자로만 이루어져있습니다.
- s는 "0"으로 시작하지 않습니다.

### 입출력 예
예를들어 str이 "1234"이면 1234를 반환하고, "-1234"이면 -1234를 반환하면 됩니다.
str은 부호(+,-)와 숫자로만 구성되어 있고, 잘못된 값이 입력되는 경우는 없습니다.
- "1234" → 1234
- "-1234" → -1234

## 🧰 풀이
```java
class Solution {
    public int solution(String s) {
        return Integer.parseInt(s);
    }
}
```
### 풀이 과정
1. Java의 Integer 클래스에서 제공하는 parseInt() 메소드를 사용하여 String을 int로 변환


2. parseInt() 메소드는 문자열 앞의 부호(+, -)도 자동으로 처리


### 시간복잡도
      - O(n): n은 문자열의 길이
         - parseInt()는 문자열을 한 번 순회하며 각 문자를 숫자로 변환
         - 부호 확인: O(1)
         - 문자열 순회: O(n)

### 공간복잡도
      - O(1)
         - 입력 문자열 외에 추가 공간을 사용하지 않음
         - 단일 정수값만 반환

## ✨ 새롭게 배운 점
1. parseInt() 메소드의 특징

    - 부호 자동 처리
    - NumberFormatException 발생 가능성 (잘못된 형식의 입력 시)
    - 다양한 진수 변환 지원 (두 번째 매개변수로 진수 지정 가능)


2. 문자열 → 정수 변환의 다양한 방법

    - Integer.valueOf()
    - Long.parseLong()
    - Double.parseDouble()


## 💡 개선할 수 있는 점
1. 예외 처리 및 입력값 검증

```java
public int solution(String s) {
    // null 또는 빈 문자열 체크
    if (s == null || s.isEmpty()) {
        throw new IllegalArgumentException("Input cannot be null or empty");
    }

    try {
        // 기본 구현
        return Integer.parseInt(s);
    } catch (NumberFormatException e) {
        // 잘못된 형식의 문자열 처리
        throw new IllegalArgumentException("Invalid number format: " + s, e);
    }
}
```
   - 문자열 형식 검증을 정규식으로 처리
   - 가독성이 좋고 확장성 있는 검증 로직
   - 실무에서 유용한 패턴


2. 성능 최적화를 위한 직접 구현

```java
public int solution(String s) {
    int result = 0;
    boolean isNegative = s.charAt(0) == '-';

    // 부호가 있는 경우 시작 인덱스를 1로 설정
    int startIdx = (s.charAt(0) == '+' || s.charAt(0) == '-') ? 1 : 0;

    for (int i = startIdx; i < s.length(); i++) {
        result = result * 10 + (s.charAt(i) - '0');
    }

    return isNegative ? -result : result;
}
```
   - `parseInt()` 내부 동작을 직접 구현
   - 문자열을 한 번만 순회하므로 효율적
   - ASCII 코드 값의 차이를 이용해 char를 int로 변환


3. 메서드 체이닝을 활용한 함수형 접근
```java
public int solution(String s) {
    return Optional.ofNullable(s)                   // null 안전성을 위해 Optional로 감싸기
            .filter(str -> !str.isEmpty())   // 빈 문자열 필터링
            .map(Integer::parseInt)          // String을 Integer로 변환
            .orElseThrow(() -> new IllegalArgumentException("Invalid input")); // 실패시 예외 발생
}
```
   - 여러 메서드를 연속적으로 호출해서 더 간결함

```java
// 일반적인 방식
public int solution(String s) {
    if (s == null) {
        throw new IllegalArgumentException("Invalid input");
    }
    if (s.isEmpty()) {
        throw new IllegalArgumentException("Invalid input");
    }
    return Integer.parseInt(s);
}
```
   - 더 간결하게 작성