# [RGB거리](https://www.acmicpc.net/problem/1149)

## 📌 문제
RGB거리에는 집이 N개 있다. 거리는 선분으로 나타낼 수 있고, 1번 집부터 N번 집이 순서대로 있다.

집은 빨강, 초록, 파랑 중 하나의 색으로 칠해야 한다. 각각의 집을 빨강, 초록, 파랑으로 칠하는 비용이 주어졌을 때, 아래 규칙을 만족하면서 모든 집을 칠하는 비용의 최솟값을 구해보자.

- 1번 집의 색은 2번 집의 색과 같지 않아야 한다.
- N번 집의 색은 N-1번 집의 색과 같지 않아야 한다.
- i(2 ≤ i ≤ N-1)번 집의 색은 i-1번, i+1번 집의 색과 같지 않아야 한다.

### 입력
첫째 줄에 집의 수 N(2 ≤ N ≤ 1,000)이 주어진다. 둘째 줄부터 N개의 줄에는 각 집을 빨강, 초록, 파랑으로 칠하는 비용이 1번 집부터 한 줄에 하나씩 주어진다. 집을 칠하는 비용은 1,000보다 작거나 같은 자연수이다.

### 출력
첫째 줄에 모든 집을 칠하는 비용의 최솟값을 출력한다.

### 예제 입력 1

     3
     26 40 83
     49 60 57
     13 89 99

### 예제 출력 1

     96


### 예제 입력 2

     3
     1 100 100
     100 1 100
     100 100 1

### 예제 출력 2

     3


### 예제 입력 3

     3
     1 100 100
     100 100 100
     1 100 100

### 예제 출력 3

     102


### 예제 입력 4

     6
     30 19 5
     64 77 64
     15 19 97
     4 71 57
     90 86 84
     93 32 91

### 예제 출력 4

     208


### 예제 입력 5

     8
     71 39 44
     32 83 55
     51 37 63
     89 29 100
     83 58 11
     65 13 15
     47 25 29
     60 66 19

### 예제 출력 5

     253




### 🧰 풀이 과정

동적 계획법(DP)을 사용하여 해결
1. 초기값 설정
   - memo[1] = 1 (1)
   - memo[2] = 2 (1+1, 2)
   - memo[3] = 4 (1+1+1, 1+2, 2+1, 3)


2. 점화식 도출
   - n을 만들기 위해서는:
     - (n-1)에 1을 더하는 경우
     - (n-2)에 2를 더하는 경우
     - (n-3)에 3을 더하는 경우
   - 따라서 memo[n] = memo[n-3] + memo[n-2] + memo[n-1]


3. Bottom-up 방식으로 구현
   - 4부터 n까지 반복하며 점화식 적용
   - memo 배열에 결과값 저장


4. 최적화된 입출력 처리
   - BufferedReader, StringBuilder, BufferedWriter 활용



### 시간복잡도와 공간복잡도

      
      시간복잡도: O(T * N)
         - T개의 테스트 케이스에 대해
         - 각각 N까지의 계산 수행
         - 각 계산은 O(1)
         - 따라서 전체 시간복잡도는 O(T * N)
      
      공간복잡도: O(N)
         - 각 테스트 케이스마다 크기 N+1의 memo 배열 사용
         - StringBuilder는 최종 출력을 위한 문자열 저장: O(T) (이는 N보다 작으므로 전체 공간복잡도에 영향 X)
         - 전체 공간복잡도는 O(N)



### ✨ 새롭게 배운 점
1. DP를 활용한 문제 해결 패턴
   - 작은 문제의 해를 이용해 큰 문제 해결
   - Bottom-up 방식의 구현
   - 메모이제이션을 통한 중복 계산 방지


2. 효율적인 입출력 처리
   - BufferedReader로 빠른 입력 처리
   - StringBuilder로 문자열 연산 최적화
   - BufferedWriter로 출력 성능 향상


3. 점화식 도출 과정
   - 작은 케이스부터 패턴 발견
   - 문제를 부분 문제로 나누어 해결

### 💡 성능 개선 포인트
1. 메모리 사용 최적화

   ```java
   // 현재: 매 테스트 케이스마다 새로운 배열 생성
   int[] memo = new int[n + 1];
   
   // 개선: 최대 크기로 한 번만 배열 생성
   int[] memo = new int[11];  // 문제 제한 n < 11
   ```

2. 반복 계산 제거
   - 내가 푼 코드는 테스트 케이스마다 새로 계산하고 있음
   - 이를 모든 케이스에 대한 결과를 미리 계산해두고 재사용하는 게 좋음 (더 큰 범위에서의 memoization)

   
   ```java
   public class Main {
       static int[] memo = new int[11];  // 문제 제한이 n < 11이므로
       
       public static void main(String[] args) throws IOException {
           // 미리 1부터 10까지 모든 경우 계산해두기
           memo[1] = 1;
           memo[2] = 2;
           memo[3] = 4;
           for(int i = 4; i <= 10; i++) {
               memo[i] = memo[i-3] + memo[i-2] + memo[i-1];
           }
           
           // 이제 테스트 케이스에서는 계산된 값만 가져다 씀
           BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           StringBuilder sb = new StringBuilder();
           int T = Integer.parseInt(br.readLine());
           
           for(int i = 0; i < T; i++) {
               int n = Integer.parseInt(br.readLine());
               sb.append(memo[n]).append('\n');  // 미리 계산된 값 사용
           }
           
           BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
           bw.write(sb.toString());
           bw.flush();
           bw.close();
       }
   }
   ```