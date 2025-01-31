# [팰린드롬수](https://www.acmicpc.net/problem/1259)

## 📌 문제
어떤 단어를 뒤에서부터 읽어도 똑같다면 그 단어를 팰린드롬이라고 한다. 'radar', 'sees'는 팰린드롬이다.

수도 팰린드롬으로 취급할 수 있다. 수의 숫자들을 뒤에서부터 읽어도 같다면 그 수는 팰린드롬수다. 121, 12421 등은 팰린드롬수다. 123, 1231은 뒤에서부터 읽으면 다르므로 팰린드롬수가 아니다. 또한 10도 팰린드롬수가 아닌데, 앞에 무의미한 0이 올 수 있다면 010이 되어 팰린드롬수로 취급할 수도 있지만, 특별히 이번 문제에서는 무의미한 0이 앞에 올 수 없다고 하자.

### 입력
입력은 여러 개의 테스트 케이스로 이루어져 있으며, 각 줄마다 1 이상 99999 이하의 정수가 주어진다. 입력의 마지막 줄에는 0이 주어지며, 이 줄은 문제에 포함되지 않는다.

### 출력
각 줄마다 주어진 수가 팰린드롬수면 'yes', 아니면 'no'를 출력한다.

### 예제 입력 1

     121
     1231
     12421
     0

### 예제 출력 1

     yes
     no
     yes


### 🧰 풀이 과정

1. BufferedReader, StringBuilder, BufferedWriter 초기화
   - String 자체엔 reverse() 메소드 없어서 StringBuilder의 reverse() 이용함


2. 무한 루프로 입력 처리, "0" 입력받으면 전체 결과 출력 후 종료


3. StringBuilder.reverse()로 문자열 뒤집기


4. 원본과 뒤집은 문자열 비교
   - 같으면 "yes", 다르면 "no" 추가


### 시간복잡도와 공간복잡도

      
      시간복잡도: O(N * L)
         - N: 입력 케이스 수
         - L: 각 입력 문자열의 최대 길이
         - StringBuilder.reverse(): O(L)
         - String.equals(): O(L)
         - while 루프: O(N)
         - 각 케이스마다 O(L) 작업 수행하니까
      
      공간복잡도: O(N)
         - 결과를 저장하는 StringBuilder: O(N)
         - 각 입력 문자열: O(1)
         - reversed 문자열: O(1)


### ✨ 새롭게 배운 점
1. StringBuilder 활용
   - reverse() 메소드로 문자열 뒤집기
   - toString()으로 String 변환


### 💡 성능 개선 포인트
1. 수학적 접근으로 개선

```java
private static boolean isPalindrome(int num) {
   if (num < 0) return false;
   int reversed = 0;
   int original = num;

   while (num > 0) {
      reversed = reversed * 10 + num % 10;
      num /= 10;
   }
   return original == reversed;
}
```


2. char 배열 직접 비교

```java
private static boolean isPalindrome(String str) {
    int left = 0;
    int right = str.length() - 1;
    
    while (left < right) {
        if (str.charAt(left++) != str.charAt(right--)) {
            return false;
        }
    }
    return true;
}
```