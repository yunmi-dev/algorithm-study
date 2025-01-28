# [문자열 반복](https://www.acmicpc.net/problem/2675)

## 📌 문제
문자열 S를 입력받은 후에, 각 문자를 R번 반복해 새 문자열 P를 만든 후 출력하는 프로그램을 작성하시오. 즉, 첫 번째 문자를 R번 반복하고, 두 번째 문자를 R번 반복하는 식으로 P를 만들면 된다. S에는 QR Code "alphanumeric" 문자만 들어있다.

QR Code "alphanumeric" 문자는 0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ\$%*+-./: 이다.

### 입력
첫째 줄에 테스트 케이스의 개수 T(1 ≤ T ≤ 1,000)가 주어진다. 각 테스트 케이스는 반복 횟수 R(1 ≤ R ≤ 8), 문자열 S가 공백으로 구분되어 주어진다. S의 길이는 적어도 1이며, 20글자를 넘지 않는다.

### 출력
각 테스트 케이스에 대해 P를 출력한다.

### 예제 입력 1

     2
     3 ABC
     5 /HTP

### 예제 출력 1

     AAABBBCCC
     /////HHHHHTTTTTPPPPP


### 🧰 풀이 과정

1. 입력 처리
   - BufferedReader로 테스트 케이스 개수 T 입력
   - 각 테스트 케이스마다 StringTokenizer로 반복 횟수 R과 문자열 S 분리


2. 문자열 처리
   - StringBuilder를 사용하여 효율적인 문자열 연산
   - 각 문자열을 문자 배열로 변환 후 처리
   - 이중 반복문으로 각 문자를 R번씩 반복 추가


3. 출력 처리
   - 각 테스트 케이스 결과 뒤에 개행문자 추가
   - 최종 결과를 BufferedWriter로 출력



### 시간복잡도와 공간복잡도

      
      시간복잡도: O(T × S × R)
         - T: 테스트 케이스 수
         - S: 입력 문자열 길이 (최대 20)
         - R: 반복 횟수 (최대 8)
         - 각 테스트 케이스에서 문자열의 각 문자를 R번 반복
         - 문제의 제약조건(T ≤ 1,000, S ≤ 20, R ≤ 8)에 의해 실제로는 O(T)로 볼 수 있음
      
      공간복잡도: O(S × R)
         - StringBuilder에 저장되는 문자열 크기는 한 번에 하나의 테스트 케이스만큼만 증가
         - 각 테스트 케이스마다 StringBuilder는 이전 결과에 새로운 결과를 추가
         - 최대 크기는 가장 긴 테스트 케이스의 결과 크기
         - 한 테스트 케이스의 최대 출력 크기: S × R (문자열 길이 × 반복 횟수)
         - T는 공간복잡도에 영향을 주지 않음
         - 추가로 사용되는 공간
            - BufferedReader, BufferedWriter: O(1)
            - StringTokenizer: O(S)
            - str.toCharArray(): O(S)



### 💡 성능 개선 포인트
1. char 배열 재사용

```java
// 현재: 매 반복마다 새로운 char 배열 생성
for (char ch : str.toCharArray())

// 개선: char 배열 한 번만 생성
char[] chars = str.toCharArray();
for (char ch : chars)
```