# [문자 반복 출력하기](https://school.programmers.co.kr/learn/courses/30/lessons/120825)

## 📌 문제 설명
문자열 `my_string`과 정수 n이 매개변수로 주어질 때, `my_string`에 들어있는 각 문자를 n만큼 반복한 문자열을 return 하도록 solution 함수를 완성해보세요.

### 제한사항

- 2 ≤ `my_string` 길이 ≤ 5
- 2 ≤ `n` ≤ 10
- "my_string"은 영어 대소문자로 이루어져 있습니다.

### 입출력 예
| my_string | n | result            |
|-----------|---|-------------------|
| "hello"   | 3 | "hhheeellllllooo" |

### 입출력 예 설명
입출력 예 #1
- "hello"의 각 문자를 세 번씩 반복한 "hhheeellllllooo"를 return 합니다.

## 🧰 풀이
이 문제는 Java의 StringBuilder 클래스를 활용하여 효율적으로 해결할 수 있습니다.

### 풀이 과정
1. 빈 StringBuilder 객체 생성
    - `StringBuilder sb = new StringBuilder()`


2. n만큼 문자 반복 출력하기
    - StringBuilder의 append() 메소드 + 반복문
   ```java
      for (int j = 0; j < n; j++) {
           sb.append(ch);
      }
   ```


3. 결과 반환
    - StringBuilder를 String으로 변환하여 반환하여야 함
    - `return sb.toString()`

### 시간복잡도
- O(m*n): m은 문자열 길이, n은 반복 횟수
   - 각 문자(m)를 n번씩 반복하므로 m*n번의 연산 발생

### 공간복잡도
- O(m*n): m은 문자열 길이, n은 반복 횟수
   - StringBuilder에 각 문자를 n번씩 저장하므로 m*n 크기의 공간 사용

## ✨ 새롭게 배운 점
1. StringBuilder 클래스의 활용
   - String은 불변(immutable)이지만 StringBuilder는 가변(mutable)
   - 문자열 조작 작업에서 StringBuilder가 더 효율적


2. 중첩 반복문을 활용한 문자 반복
   - 바깥 반복문으로 각 문자에 접근
   - 안쪽 반복문으로 각 문자를 n번 반복