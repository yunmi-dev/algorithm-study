# [설탕 배달](https://www.acmicpc.net/problem/2839)

## 📌 문제
상근이는 요즘 설탕공장에서 설탕을 배달하고 있다. 상근이는 지금 사탕가게에 설탕을 정확하게 N킬로그램을 배달해야 한다. 설탕공장에서 만드는 설탕은 봉지에 담겨져 있다. 봉지는 3킬로그램 봉지와 5킬로그램 봉지가 있다.

상근이는 귀찮기 때문에, 최대한 적은 봉지를 들고 가려고 한다. 예를 들어, 18킬로그램 설탕을 배달해야 할 때, 3킬로그램 봉지 6개를 가져가도 되지만, 5킬로그램 3개와 3킬로그램 1개를 배달하면, 더 적은 개수의 봉지를 배달할 수 있다.

상근이가 설탕을 정확하게 N킬로그램 배달해야 할 때, 봉지 몇 개를 가져가면 되는지 그 수를 구하는 프로그램을 작성하시오.

### 입력
첫째 줄에 N이 주어진다. (3 ≤ N ≤ 5000)

### 출력
상근이가 배달하는 봉지의 최소 개수를 출력한다. 만약, 정확하게 N킬로그램을 만들 수 없다면 -1을 출력한다.

### 예제 입력 1

     18

### 예제 출력 1

     4



### 예제 입력 2

     4

### 예제 출력 2

     -1



### 예제 입력 3

     6

### 예제 출력 3

     2



### 예제 입력 4

     9

### 예제 출력 4

     3



### 예제 입력 5

     11

### 예제 출력 5

     3





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