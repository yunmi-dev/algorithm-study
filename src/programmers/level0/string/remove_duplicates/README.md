# [중복된 문자 제거](https://school.programmers.co.kr/learn/courses/30/lessons/120888)

## 📌 문제 설명
문자열 `my_string`이 매개변수로 주어집니다. `my_string`에서 중복된 문자를 제거하고 하나의 문자만 남긴 문자열을 return하도록 solution 함수를 완성해주세요.

### 제한사항

- 1 ≤ my_string ≤ 110
- my_string은 대문자, 소문자, 공백으로 구성되어 있습니다.
- 대문자와 소문자를 구분합니다.
- 공백(" ")도 하나의 문자로 구분합니다.
- 중복된 문자 중 가장 앞에 있는 문자를 남깁니다.

### 입출력 예
| my_string | result |
|-----------|--------|
| "people"   | 	"peol"      |
| "We are the world"   | "We arthwold"      |

### 입출력 예 설명
입출력 예 #1
- "people"에서 중복된 문자 "p"와 "e"을 제거한 "peol"을 return합니다.

입출력 예 #2
- "We are the world"에서 중복된 문자 "e", " ", "r" 들을 제거한 "We arthwold"을 return합니다.


## 🧰 풀이
HashSet과 StringBuilder를 활용하여 중복 문자를 효율적으로 제거할 수 있다.

### 풀이 과정
1. 필요한 자료구조 초기화
   - StringBuilder: 결과 문자열을 만들기 위한 가변 문자열 객체
   - HashSet<Character>: 이미 등장한 문자를 저장하는 집합


2. 문자열 순회하며 중복 체크
   - charAt()으로 각 문자에 접근
   - HashSet의 contains()로 중복 체크
   - 처음 등장하는 문자만 StringBuilder에 추가
   - 등장한 문자는 HashSet에 저장

3. 결과 반환
   - StringBuilder를 String으로 변환하여 반환

### 시간복잡도
      - O(N): N은 문자열의 길이
        - 문자열 순회: O(N)
        - HashSet 연산(contains, add): O(1)
        - StringBuilder 연산(append): O(1)

### 공간복잡도
      - O(N): N은 문자열의 길이
        - HashSet 공간: O(N)
        - StringBuilder 공간: O(N)

## ✨ 새롭게 배운 점
1. HashSet의 활용성
   - HashSet의 contains() 메소드로 효율적인 중복 체크 (Good)
   - 검색, 삽입이 O(1)로 매우 빠름


2. StringBuilder의 효율적인 사용
   - String은 불변이라 매번 새 객체를 생성해야 함
   - StringBuilder는 가변이라 메모리 효율적
   - append() 메소드로 문자열 이어붙이기