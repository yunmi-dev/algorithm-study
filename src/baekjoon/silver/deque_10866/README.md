# [덱](https://www.acmicpc.net/problem/10866)

## 📌 문제
정수를 저장하는 덱(Deque)를 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.

명령은 총 여덟 가지이다.

- push_front X: 정수 X를 덱의 앞에 넣는다.
- push_back X: 정수 X를 덱의 뒤에 넣는다.
- pop_front: 덱의 가장 앞에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
- pop_back: 덱의 가장 뒤에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
- size: 덱에 들어있는 정수의 개수를 출력한다.
- empty: 덱이 비어있으면 1을, 아니면 0을 출력한다.
- front: 덱의 가장 앞에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
- back: 덱의 가장 뒤에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.

### 입력
첫째 줄에 주어지는 명령의 수 N (1 ≤ N ≤ 10,000)이 주어진다. 둘째 줄부터 N개의 줄에는 명령이 하나씩 주어진다. 주어지는 정수는 1보다 크거나 같고, 100,000보다 작거나 같다. 문제에 나와있지 않은 명령이 주어지는 경우는 없다.

### 출력
출력해야하는 명령이 주어질 때마다, 한 줄에 하나씩 출력한다.

### 예제 입력 1

     15
     push_back 1
     push_front 2
     front
     back
     size
     empty
     pop_front
     pop_back
     pop_front
     size
     empty
     pop_back
     push_front 3
     empty
     front

### 예제 출력 1

     2
     1
     2
     0
     2
     1
     -1
     0
     1
     -1
     0
     3


### 예제 입력 2

     22
     front
     back
     pop_front
     pop_back
     push_front 1
     front
     pop_back
     push_back 2
     back
     pop_front
     push_front 10
     push_front 333
     front
     back
     pop_back
     pop_back
     push_back 20
     push_back 1234
     front
     back
     pop_back
     pop_back

### 예제 출력 2

     -1
     -1
     -1
     -1
     1
     1
     2
     2
     333
     10
     10
     333
     20
     1234
     1234
     20



### 🧰 풀이 과정

LinkedList를 이용해 덱(Deque) 구현


### 시간복잡도와 공간복잡도


    시간복잡도: O(N)
         - add(0, X) (push_front) - O(1)
         - add(size, X) (push_back) - O(1)
         - remove(0) (pop_front) - O(1)
         - remove(size-1) (pop_back) - O(1)
         - get(0) (front) - O(1)
         - get(size-1) (back) - O(1)
         - size() - O(1)
         - isEmpty() - O(1)
      - 각 명령어는 위 연산들 중 하나만 수행, 전체 명령 수가 N개이므로 전체 시간복잡도는 O(N)

    공간복잡도: O(N)
      - LinkedList에 저장되는 최대 요소 수: O(N)
      - 결과를 저장하는 ArrayList의 크기: O(N)
      - 따라서 총 O(N)의 공간 필요


### ✨ 새롭게 배운 점
1. LinkedList 메서드 활용
   - add(index, element)로 특정 위치에 삽입, remove(index)로 특정 위치 삭제
   - LinkedList로 Deque 인터페이스 구현돼있음
   - push() 메소드는 가장 뒤가 아닌, 가장 앞에 요소를 추가한다는 점 주의

   
### 💡 성능 개선 포인트
1. ArrayList 대신 StringBuilder 사용 가능
   - 지금처럼 결과마다 println() 호출하지 말고 StringBuilder로 결과 모았다가 한번에 출력하는 게 더 효율적


2. ArrayDeque 사용도 고려
   - LinkedList보다 ArrayDeque가 보통 더 나은 성능을 보임

→ 상태 관리 방식이 코드의 안정성 & 가독성에 큰 영향을 미침