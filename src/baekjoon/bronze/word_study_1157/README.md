# [단어 공부](https://www.acmicpc.net/problem/1157)

## 📌 문제
알파벳 대소문자로 된 단어가 주어지면, 이 단어에서 가장 많이 사용된 알파벳이 무엇인지 알아내는 프로그램을 작성하시오. 단, 대문자와 소문자를 구분하지 않는다.

### 입력
첫째 줄에 알파벳 대소문자로 이루어진 단어가 주어진다. 주어지는 단어의 길이는 1,000,000을 넘지 않는다.

### 출력
첫째 줄에 이 단어에서 가장 많이 사용된 알파벳을 대문자로 출력한다. 단, 가장 많이 사용된 알파벳이 여러 개 존재하는 경우에는 ?를 출력한다.

### 예제 입력 1

     Mississipi

### 예제 출력 1

     ?


### 예제 입력 2

     zZa

### 예제 출력 2

     Z

### 예제 입력 3

     z

### 예제 출력 3

     Z

### 예제 입력 4

     baaa

### 예제 출력 4

     A




### 🧰 풀이 과정

1. 입력 전처리
   - BufferedReader로 단어 입력 받기
   - toUpperCase()로 모든 문자를 대문자로 변환


2. 알파벳 카운팅
   - 크기 26의 int 배열로 각 알파벳 출현 횟수 저장
   - 각 문자에서 'A'를 빼서 인덱스(0-25) 계산
   - 해당 인덱스의 카운트 증가


3. 최다 출현 알파벳 찾기
   - maxCount로 최대 출현 횟수 관리
   - maxIndex로 최다 출현 알파벳의 인덱스 저장
   - isDuplicate로 최대 출현 횟수가 중복되는지 체크


4. 결과 출력
   - 중복이면 '?' 출력
   - 중복이 아니면 해당 인덱스를 다시 알파벳으로 변환하여 출력


### 시간복잡도와 공간복잡도

      
      시간복잡도: O(N)
         - word.toCharArray() 순회: O(N) (N은 단어 길이)
         - counts 배열 순회: O(1) (항상 26번)
         - 전체 시간복잡도는 O(N)
      
      공간복잡도: O(1)
         - counts 배열: O(1) (크기 26 고정)
         - 기타 변수들: O(1)
         - 입력 문자열 저장: O(1) (최대 1,000,000으로 제한)


### ✨ 새롭게 배운 점
1. 문자와 인덱스 변환
   - char에서 인덱스로: ch - 'A'
   - 인덱스에서 char로: (char)(index + 'A')


2. 최댓값 중복 체크 방법
   - 현재값이 최대일 때 초기화
   - 현재값이 최대와 같을 때 중복 표시


### 💡 성능 개선 포인트
1. toCharArray() 대신 charAt() 사용 가능

```java
// 현재: word.toCharArray() 사용
// 개선: word.charAt(i) 사용하여 불필요한 배열 생성 방지
for (int i = 0; i < word.length(); i++) {
    counts[word.charAt(i) - 'A']++;
}
```

2. 알파벳 카운팅과 최댓값 찾기를 한 번에 처리

```java
int maxCount = 0;
char maxChar = '?';
for (char ch : word.toCharArray()) {
    int count = ++counts[ch - 'A'];
    if (count > maxCount) {
        maxCount = count;
        maxChar = ch;
        isDuplicate = false;
    } else if (count == maxCount) {
        isDuplicate = true;
    }
}
```
