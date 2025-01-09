# [배열 회전시키기](https://school.programmers.co.kr/learn/courses/30/lessons/120844)

## 📌 문제 설명
정수가 담긴 배열 numbers와 문자열 direction가 매개변수로 주어집니다. 배열 numbers의 원소를 direction방향으로 한 칸씩 회전시킨 배열을 return하도록 solution 함수를 완성해주세요.

### 제한사항

- 3 ≤ numbers의 길이 ≤ 20
- direction은 "left" 와 "right" 둘 중 하나입니다.

### 입출력 예
| numbers  | direction | result |
|----|-----------|---|
| [1, 2, 3]  | "right"        | [3, 1, 2] |
| [4, 455, 6, 4, -1, 45, 6] | 	"left"        | 	[455, 6, 4, -1, 45, 6, 4] |

### 입출력 예 설명
입출력 예 #1
- numbers 가 [1, 2, 3]이고 direction이 "right" 이므로 오른쪽으로 한 칸씩 회전시킨 [3, 1, 2]를 return합니다.

입출력 예 #2
- numbers 가 [4, 455, 6, 4, -1, 45, 6]이고 direction이 "left" 이므로 왼쪽으로 한 칸씩 회전시킨 [455, 6, 4, -1, 45, 6, 4]를 return합니다.


## 🧰 풀이
ArrayList를 활용하여 배열의 회전을 구현할 수 있다.

### 풀이 과정
1. numbers 배열의 요소들을 ArrayList로 변환
   - 배열 조작을 더 쉽게 하기 위해 ArrayList 사용
   - Enhanced for loop 사용해서 각 요소를 리스트에 추가


2. direction에 따라 회전 방향 결정
   - "right"인 경우:
       - 마지막 요소를 제거(remove)하고 첫 위치(0)에 추가(add)
   - "left"인 경우:
       - 첫 요소를 제거하고 마지막 위치에 추가


3. ArrayList를 다시 배열로 변환 (꼭 해줘야함)
   - Stream API를 사용하여 Integer 리스트를 int 배열로 변환


### 시간복잡도
    - O(N): N은 배열의 길이
      - ArrayList 변환: O(N)
      - 요소 제거 및 추가: O(1)
      - 배열로 변환: O(N)

### 공간복잡도
    - O(N): N은 배열의 길이
      - ArrayList를 저장하기 위한 추가 공간 필요

## ✨ 새롭게 배운 점
1. ArrayList의 효율적인 활용
   - remove()나 add() 메소드 + 특정 위치의 요소를 제거하고 원하는 위치에 추가 가능하여 활용도가 매우 높았음

2. Stream API를 활용한 타입 변환
   - list.stream().mapToInt(i->i).toArray()를 통해 ArrayList<Integer>를 int[]로 변환
   - 람다식을 활용한 간결한 변환 방법
