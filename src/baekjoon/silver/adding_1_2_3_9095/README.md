# [1, 2, 3 더하기](https://www.acmicpc.net/problem/9095)

## 📌 문제
정수 4를 1, 2, 3의 합으로 나타내는 방법은 총 7가지가 있다. 합을 나타낼 때는 수를 1개 이상 사용해야 한다.

- 1+1+1+1
- 1+1+2
- 1+2+1
- 2+1+1
- 2+2
- 1+3
- 3+1

정수 n이 주어졌을 때, n을 1, 2, 3의 합으로 나타내는 방법의 수를 구하는 프로그램을 작성하시오.

### 입력
첫째 줄에 테스트 케이스의 개수 T가 주어진다. 각 테스트 케이스는 한 줄로 이루어져 있고, 정수 n이 주어진다. n은 양수이며 11보다 작다.

### 출력
각 테스트 케이스마다, n을 1, 2, 3의 합으로 나타내는 방법의 수를 출력한다.

### 예제 입력 1

     3
     4
     7
     10

### 예제 출력 1

     7
     44
     274


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