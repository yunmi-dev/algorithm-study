# [스택 수열](https://www.acmicpc.net/problem/1874)

## 📌 문제
스택 (stack)은 기본적인 자료구조 중 하나로, 컴퓨터 프로그램을 작성할 때 자주 이용되는 개념이다. 스택은 자료를 넣는 (push) 입구와 자료를 뽑는 (pop) 입구가 같아 제일 나중에 들어간 자료가 제일 먼저 나오는 (LIFO, Last in First out) 특성을 가지고 있다.

1부터 n까지의 수를 스택에 넣었다가 뽑아 늘어놓음으로써, 하나의 수열을 만들 수 있다. 이때, 스택에 push하는 순서는 반드시 오름차순을 지키도록 한다고 하자. 임의의 수열이 주어졌을 때 스택을 이용해 그 수열을 만들 수 있는지 없는지, 있다면 어떤 순서로 push와 pop 연산을 수행해야 하는지를 알아낼 수 있다. 이를 계산하는 프로그램을 작성하라.

### 입력
첫 줄에 n (1 ≤ n ≤ 100,000)이 주어진다. 둘째 줄부터 n개의 줄에는 수열을 이루는 1이상 n이하의 정수가 하나씩 순서대로 주어진다. 물론 같은 정수가 두 번 나오는 일은 없다.

### 출력
입력된 수열을 만들기 위해 필요한 연산을 한 줄에 한 개씩 출력한다. push연산은 +로, pop 연산은 -로 표현하도록 한다. 불가능한 경우 NO를 출력한다.

### 예제 입력 1

     8
     4
     3
     6
     8
     7
     5
     2
     1


### 예제 출력 1

     +
     +
     +
     +
     -
     -
     +
     +
     -
     +
     +
     -
     -
     -
     -
     -

### 예제 입력 2

     5
     1
     2
     5
     3
     4

### 예제 출력 2

     NO

### 힌트
1부터 n까지에 수에 대해 차례로 [push, push, push, push, pop, pop, push, push, pop, push, push, pop, pop, pop, pop, pop] 연산을 수행하면 수열 [4, 3, 6, 8, 7, 5, 2, 1]을 얻을 수 있다.



### 🧰 풀이 과정

#### 첫번째 접근 (시간 초과)

1. Stack과 ArrayList를 함께 사용
   - Stack: 현재 처리중인 숫자들 저장
   - ArrayList(history): 이미 사용한 숫자들 저장해 중복 체크


2. 각 입력값(k)에 대해:
   - 스택이 비어있으면 1을 push
   - 스택 top이 k보다 작으면 k까지 순차적으로 push
   - k와 같으면 pop
   - 그 외의 경우 수열 생성 불가능


#### 두번째 접근 (성공)

1. Stack만 사용
   - currentNum 변수로 다음에 push할 숫자 관리
   - history ArrayList 제거로 contains() 연산 제거


2. 각 입력값(target)에 대해:
   - currentNum부터 target까지 순차적으로 push
   - stack의 top이 target과 같으면 pop
   - 그 외의 경우 수열 생성 불가능



### 시간복잡도와 공간복잡도

#### 첫번째 접근
    시간복잡도: O(n²)
      - 전체 순회: O(n)
         - history.contains() 연산: O(n)
         - for문으로 숫자 push: 최악의 경우 O(n)
      - n개의 입력에 대해 각각 최대 n번의 contains() 연산 수행 -> 총 O(n²)
      - 결국 시간 초과 발생

    공간복잡도: O(n)
      - Stack: 최대 n개 원소 → O(n)
      - ArrayList(history): 최대 n개 원소 → O(n)
      - StringBuilder: 최대 2n개 문자(+/-) → O(n)
      - 총 공간복잡도: O(n)

#### 두번째 접근
    시간복잡도: O(n)
      - 전체 순회: O(n)
         - push 연산: 총 n번 발생 (각 숫자는 정확히 한 번씩만 push됨)
         - pop 연산: 총 n번 발생 (push된 모든 숫자는 한 번씩 pop됨)
         - 각 push/pop 연산: O(1)
      - 모든 숫자가 무조건 한번씩 push되고 pop되므로 총 O(n) 소요

    공간복잡도: O(n)
      - Stack: 최대 n개 원소 → O(n)
      - StringBuilder: 최대 2n개 문자(+/-) → O(n)
      - 기타 변수(currentNum 등): O(1)
      - 총 공간복잡도: O(n)



### ✨ 새롭게 배운 점
1. 자료구조 선택의 중요성
   - ArrayList의 contains() 연산은 O(n)이므로 빈번한 사용 시 성능 저하
   - 불필요한 자료구조 사용 지양 (history ArrayList)


2. 변수를 활용한 상태 관리
   - currentNum으로 다음 push할 숫자 관리
   - 별도의 배열 없이도 중복/순서 체크 가능


3. 조기 종료(Early return)의 활용
   - 불가능한 경우 즉시 "NO" 출력 후 종료
   - 불필요한 연산 방지


4. StringBuilder 활용
   - 많은 출력이 필요한 경우 StringBuilder 사용
   - System.out.println() 반복 사용 대비 성능 향상