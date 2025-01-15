# [문자 리스트를 문자열로 변환하기](https://school.programmers.co.kr/learn/courses/30/lessons/181941)

## 📌 문제 설명
문자들이 담겨있는 배열 `arr`가 주어집니다. `arr`의 원소들을 순서대로 이어 붙인 문자열을 return 하는 solution함수를 작성해 주세요.

### 제한사항

- 1 ≤ `arr`의 길이 ≤ 200
   - arr의 원소는 전부 알파벳 소문자로 이루어진 길이가 1인 문자열입니다.

### 입출력 예
| arr | result |
|-----------|--------|
| ["a","b","c"]   | 	"abc"      |


## 🧰 풀이

### 풀이 과정
1. StringBuilder 객체 생성


2. for-each 루프로 배열을 순회하며 각 문자열을 StringBuilder에 추가

3. StringBuilder를 String으로 변환하여 반환

### 시간복잡도
      - O(N): N은 배열의 길이
         - 배열 순회: O(N)
         - StringBuilder append 연산: 평균 O(1)
         - toString() 변환: O(N)

### 공간복잡도
      - O(N): N은 모든 문자열의 총 길이
         - StringBuilder 버퍼: O(N)
         - 최종 반환되는 String: O(N)

## 💡 개선할 수 있는 점
1. String.join() 메소드 활용

```java
public String solution(String[] arr) {
   return String.join("", arr);
}
```
   - 문자열 배열을 하나의 문자열로 합치는 메소드가 애초에 있었음
   - join(" ", arr) 으로 하면 공백으로 합치기도 가능
   - 간결하면서, 내부적으로 최적화돼 있어 성능도 좋음


2. 자바의 Stream API 활용

```java
public String solution(String[] arr) {
    return Arrays.stream(arr)
                 .collect(Collectors.joining());
}
```
   - Arrays.stream(arr) 에서 배열을 스트림으로 변환
   - collect(): 스트림의 요소들을 수집해서 다른 형태로 변환
   - Collectors.joining(): 문자열들을 이어붙이는 수집기(Collector)를 생성
      - 구분자를 지정할 수도 있습니다: Collectors.joining(", ")

   - 함수형 프로그래밍 스타일
   - 더 선언적이고 읽기 쉬운 코드
   - 그러나 작은 크기의 배열에서는 약간의 오버헤드가 있을 수 있음