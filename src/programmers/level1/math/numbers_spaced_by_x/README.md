# [x만큼 간격이 있는 n개의 숫자](https://school.programmers.co.kr/learn/courses/30/lessons/12954)

## 📌 문제 설명
함수 solution은 정수 x와 자연수 n을 입력 받아, x부터 시작해 x씩 증가하는 숫자를 n개 지니는 리스트를 리턴해야 합니다. 다음 제한 조건을 보고, 조건을 만족하는 함수, solution을 완성해주세요.

### 제한사항

- x는 -10000000 이상, 10000000 이하인 정수입니다.
- n은 1000 이하인 자연수입니다.

### 입출력 예
| x  | n |answer|
|----|---|---|
| 2  | 5 |[2,4,6,8,10]|
| 4  | 3 |[4,8,12]|
| -4 | 2 |[-4, -8]|


## 🧰 풀이
```java
class Solution {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        long k = x;  // int -> long으로 형변환하여 오버플로우 방지
        for (int i = 0; i < n; i++) {
            answer[i] = k;
            k += x;
        }
        return answer;
    }
}
```

### 풀이 과정
1. 결과를 저장할 long[] 배열 생성


2. 오버플로우 방지를 위해 int x를 long으로 형변환


3. 반복문을 통해 x씩 증가하는 값을 배열에 저장


4. 완성된 배열 리턴


### 시간복잡도
      - O(n): n은 입력받은 자연수
         - 배열 생성: O(n)
         - 반복문 순회: O(n)

### 공간복잡도
      - O(n): n은 입력받은 자연수
         - 결과 배열 크기: O(n)
         - 기타 변수(k, i): O(1)

## ✨ 새롭게 배운 점
1. 정수 오버플로우 문제 해결
```java
// 처음 작성한 코드 - 일부 테스트 케이스 실패
public long[] solution(int x, int n) {
   long[] answer = new long[n];
   int k = x;  // 문제: int 사용
   for (int i = 0; i < n; i++) {
      answer[i] = k;
      k += x;
   }
   return answer;
}
```
   - 처음에 k를 int로 선언하여 2개의 테스트 케이스 실패
   - x와 n의 범위가 커서 중간 계산 과정에서 int 범위(-2^31 ~ 2^31-1)를 벗어남
   - k를 long으로 변경하여 오버플로우 문제 해결
   - 실제 프로젝트에서도 자주 발생할 수 있는 문제라 좋은 학습 경험
      - Java에서 int 범위: -2^31 ~ 2^31-1
      - Java에서 long 범위: -2^63 ~ 2^63-1


2. 배열의 타입 결정
   - 반환 타입이 long[]인 이유 이해
   - 결과값의 범위를 고려한 적절한 데이터 타입 선택의 중요성


## 💡 개선할 수 있는 점
1. Stream API를 활용한 함수형 프로그래밍 접근

```java
public long[] solution(int x, int n) {
   return LongStream.iterate(x, i -> i + x)
           .limit(n)
           .toArray();
}
```
   - 더 간결하고 가독성 높음
   - 그러나 기존에 풀었던 방식이 성능은 더 좋을 수 있음


2. 입력값 검증 추가

```java
public long[] solution(int x, int n) {
   if (n <= 0) {
      throw new IllegalArgumentException("n must be positive");
   }

   long[] answer = new long[n];
   long k = x;
   for (int i = 0; i < n; i++) {
      answer[i] = k;
      k += x;
   }
   return answer;
}
```
   - 잘못된 입력에 명확한 에러 메시지 제공하는 식의 방어적 프로그래밍


3. 오버플로우 검사 추가
```java
public long[] solution(int x, int n) {
    long[] answer = new long[n];
    long k = x;
    
    for (int i = 0; i < n; i++) {
        answer[i] = k;
        // 오버플로우 체크
        if (k > 0 && Long.MAX_VALUE - k < x) {
            throw new ArithmeticException("Arithmetic overflow");
        }
        if (k < 0 && Long.MIN_VALUE - k > x) {
            throw new ArithmeticException("Arithmetic overflow");
        }
        k += x;
    }
    return answer;
}
```
   - 계산 과정에서의 오버플로우 검사
   - 안정성 향상됨
   - 실무에서 중요한 엣지 케이스 처리 (극단적인 입력값이나 경계값)
   - 해당 문제에선 입력값의 범위와 입력 형식이 주어졌으므로 별도릐 엣지 케이스 처리는 불필요하나, 프로그램의 안정성 보장와 예상치 못한 버그 방지를 위해 알아야 할 부분