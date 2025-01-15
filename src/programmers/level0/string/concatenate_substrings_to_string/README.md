# [부분 문자열 이어 붙여 문자열 만들기](https://school.programmers.co.kr/learn/courses/30/lessons/181911)

## 📌 문제 설명
길이가 같은 문자열 배열 `my_strings`와 이차원 정수 배열 `parts`가 매개변수로 주어집니다. `parts[i]`는 [s, e] 형태로, `my_string[i]`의 인덱스 s부터 인덱스 e까지의 부분 문자열을 의미합니다. 각 `my_strings`의 원소의 `parts에 해당하는 부분 문자열을 순서대로 이어 붙인 문자열을 return 하는 solution 함수를 작성해 주세요.

### 제한사항

- 1 ≤ `my_strings`의 길이 = `parts`의 길이 ≤ 100
- 1 ≤ `my_strings`의 원소의 길이 ≤ 100
- `parts[i]`를 [s, e]라 할 때, 다음을 만족합니다.
  - 0 ≤ s ≤ e < `my_strings[i]의 길이

### 입출력 예
| arr | result |
|-----------|--------|
| ["a","b","c"]   | 	"abc"      |

### 입출력 예 설명
입출력 예 #1
- 예제 1번의 입력을 보기 좋게 표로 나타내면 다음과 같습니다.

|i|my_strings[i]|parts[i]|부분 문자열|
|-|-------------|--------|--------|
|0|"progressive"|[0, 4]|"progr"|
|1|"hamburger"|[1, 2]|"am"|
|2|"hammer"|[3, 5]|"mer"|
|3|"ahocorasick"|[7, 7]|"s"|

각 부분 문자열을 순서대로 이어 붙인 문자열은 "programmers"입니다. 따라서 "programmers"를 return 합니다.



## 🧰 풀이
이중 반복문과 StringBuilder를 활용하여 각 문자열의 특정 부분을 추출하고 이어 붙이는 방식으로 구현함

### 풀이 과정
1. StringBuilder 객체 생성


2. my_strings의 각 문자열에 접근


3. 부분 문자열 추출


4. 최종 StringBuilder를 String으로 변환하여 반환

### 시간복잡도
      - O(N * M): 여기서 N은 문자열 배열의 길이, M은 평균 부분 문자열의 길이
         - 외부 반복문: O(N)
         - 내부 반복문: O(M)
         - StringBuilder append 연산: O(1)
         - toString() 변환: O(K), K는 최종 문자열의 길이
            - 여기서 K는 당연히 N*M과 같음

### 공간복잡도
      - O(K): K는 최종 문자열의 길이
         - StringBuilder 버퍼: O(K)
         - 최종 반환되는 String: O(K)

## ✨ 새롭게 배운 점
1. 문자열 처리 방법의 다양성
   - charAt()을 이용한 문자 단위 접근
   - substring()을 이용한 부분 문자열 추출
   - 두 개를 쓰는 과정에서 각 방식의 장단점 이해


## 💡 개선할 수 있는 점
1. substring() 메소드 활용

```java
public String solution(String[] my_strings, int[][] parts) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < my_strings.length; i++) {
        sb.append(my_strings[i].substring(parts[i][0], parts[i][1] + 1));
    }
    return sb.toString();
}
```
   - 가독성 향상
   - 내부적으로 최적화된 메소드


2. 자바의 Stream API 활용

```java
public String solution(String[] my_strings, int[][] parts) {
    return IntStream.range(0, my_strings.length)
            .mapToObj(i -> my_strings[i].substring(parts[i][0], parts[i][1] + 1))
            .collect(Collectors.joining());
}
```
   - 함수형 프로그래밍 스타일
   - 더 선언적인 코드
   - 작은 입력에서는 약간의 오버헤드 발생 가능함을 주의
