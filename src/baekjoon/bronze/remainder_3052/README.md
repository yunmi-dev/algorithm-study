# [숫자의 합](https://www.acmicpc.net/problem/11720)

## 📌 문제
N개의 숫자가 공백 없이 쓰여있다. 이 숫자를 모두 합해서 출력하는 프로그램을 작성하시오.

### 입력
첫째 줄에 숫자의 개수 N (1 ≤ N ≤ 100)이 주어진다. 둘째 줄에 숫자 N개가 공백없이 주어진다.

### 출력
입력으로 주어진 숫자 N개의 합을 출력한다.

### 예제 입력 1

     1
     1

### 예제 출력 1

     1



### 예제 입력 2

     5
     54321

### 예제 출력 2

     15



### 예제 입력 3

     25
     7000000000000000000000000

### 예제 출력 3

     7



### 예제 입력 2

     11
     10987654321

### 예제 출력 2

     46



### 🧰 풀이 과정

1. 입력 받기


2. 숫자 합계 계산
    - String을 char 배열로 변환 (toCharArray())
    - 각 문자를 숫자로 변환하여 합계 계산
    - String.valueOf()로 char를 String으로 변환 후 parseInt()


3. 최종 합계 출력



### 시간복잡도와 공간복잡도

      
      시간복잡도: O(N)
         - 문자열 길이만큼 한 번 순회
         - toCharArray(): O(N)
         - forEach 반복: O(N)
         - 전체: O(N)
      
      공간복잡도: O(N)
         - 입력 문자열 저장: O(N)
         - char 배열 변환: O(N)
         - N은 입력 숫자의 개수


### ✨ 새롭게 배운 점
1. char를 숫자로 변환하는 방법
    - ASCII 코드 활용
        ```java
        char c = '5';
        int num = c - '0';  // 53 - 48 = 5
        ```
        - String 객체 생성이나 파싱 과정이 없고 단순 뺄셈이므로 이게 더 효율적
    - String으로 변환 후 parseInt (현재 코드에서 사용한 방식)
        ```java
        char c = '5';
        int num = Integer.parseInt(String.valueOf(c));
        ```


### 💡 성능 개선 포인트
1. 문자 → 숫자 변환 최적화

```java
// 현재: String으로 변환 후 parseInt
result += Integer.parseInt(String.valueOf(number));

// 개선: ASCII 코드 활용
result += number - '0';
```

- String 변환 없이 ASCII 코드 차이를 이용
- '0'은 48, '1'은 49... 이므로 '0'을 빼면 실제 숫자값
- 더 적은 메모리와 연산으로 같은 결과