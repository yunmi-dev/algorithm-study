# [모음 제거](https://school.programmers.co.kr/learn/courses/30/lessons/120849)

## 📌 문제 설명
영어에선 a, e, i, o, u 다섯 가지 알파벳을 모음으로 분류합니다. 문자열 `my_string`이 매개변수로 주어질 때 모음을 제거한 문자열을 return하도록 solution 함수를 완성해주세요.

### 제한사항

- `my_string`은 소문자와 공백으로 이루어져 있습니다.
- 1 ≤ `my_string`의 길이 ≤ 1,000

### 입출력 예
| my_string | result |
|-----------|--------|
| "bus"   | 	"bs"      |
| "nice to meet you"   | "nc t mt y"      |

### 입출력 예 설명
입출력 예 #1
- "bus"에서 모음 u를 제거한 "bs"를 return합니다.

입출력 예 #2
- "nice to meet you"에서 모음 i, o, e, u를 모두 제거한 "nc t mt y"를 return합니다.


## 🧰 풀이
StringBuilder와 문자열 순회를 활용하여 모음을 제거함

### 풀이 과정
1. StringBuilder 초기화
   - 가변 문자열을 다루기 위한 StringBuilder 객체 생성


2. 문자열을 문자 배열로 변환하여 순회, 모음 아닌 경우에만 sb에 추가


3. 결과 반환
   - StringBuilder를 String으로 변환하여 반환

### 시간복잡도
      O(N): N은 문자열의 길이
         - toCharArray(): O(N)
         - 문자열 순회: O(N)
         - StringBuilder append 연산: 평균 O(1)
         - toString() 변환: O(N)


### 공간복잡도
      O(N): N은 문자열의 길이
         - toCharArray()로 생성되는 문자 배열: O(N)
         - StringBuilder 버퍼: O(N)
         - 최종 반환되는 String: O(N)

## ✨ 새롭게 배운 점
1. String의 불변성 때문에 StringBuilder 사용이 효율적임
   - String으로 replace 메소드를 쓰면, 매번 새 객체가 생성됨
   - toCharArray()를 사용한 문자 단위 접근이 charAt()보다 성능상 유리할 수 있음
   - 복잡한 자료구조 없이도 간단한 조건문으로 해결