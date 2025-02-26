# [큐 2](https://www.acmicpc.net/problem/18258)

## 📌 문제
정수를 저장하는 큐를 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.

명령은 총 여섯 가지이다.
- push X: 정수 X를 큐에 넣는 연산이다.
- pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
- size: 큐에 들어있는 정수의 개수를 출력한다.
- empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
- front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
- back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.

### 입력
첫째 줄에 주어지는 명령의 수 N (1 ≤ N ≤ 2,000,000)이 주어진다. 둘째 줄부터 N개의 줄에는 명령이 하나씩 주어진다. 주어지는 정수는 1보다 크거나 같고, 100,000보다 작거나 같다. 문제에 나와있지 않은 명령이 주어지는 경우는 없다.

### 출력
출력해야하는 명령이 주어질 때마다, 한 줄에 하나씩 출력한다.

### 예제 입력 1

     15
     push 1
     push 2
     front
     back
     size
     empty
     pop
     pop
     pop
     size
     empty
     pop
     push 3
     empty
     front

### 예제 출력 1

     1
     2
     2
     0
     1
     2
     -1
     0
     1
     -1
     0
     3




### 🧰 풀이 과정

LinkedList를 활용해 큐 구현

1. 자료구조 선택
   - LinkedList는 양쪽 끝에서의 삽입/삭제가 O(1) 시간에 가능하므로 큐 구현에 적합함을 배웠던 기억이 있어, LinkedList로 선택


2. 명령어 파싱 및 처리
- BufferedReader와 StringTokenizer를 사용하여 효율적인 입력 처리
- switch-case 문으로 각 명령어 별로 로직 구현함
  - push: 리스트 끝에 요소 추가 (add)
  - pop: 리스트 첫 요소 제거 및 반환 (remove(0))
  - size: 리스트 크기 반환
  - empty: 리스트 비어있는지 확인
  - front: 첫 요소 조회 (get(0))
  - back: 마지막 요소 조회 (get(size-1))


3. 출력 최적화
   - 각 명령 결과를 StringBuilder에 누적하여 한 번에 출력
   - BufferedWriter를 사용하여 출력 성능 향상


### 시간복잡도와 공간복잡도

      
      시간복잡도: O(N)
         - add(linkedList.size(), element): O(n) - 리스트를 탐색하여 요소 추가함
         - remove(0): O(1)
         - size(): O(1)
         - isEmpty(): O(1)
         - get(0): O(1)
         - get(size-1): O(1)
            
         - 최대 N개를 저장할 수 있는 LinkedList와 출력을 위한 StringBuilder 사용 때문에 전체 시간복잡도는 O(N)

      
      공간복잡도: O(N)
         - 최대 N개의 정수를 저장하는 LinkedList 사용
         - StringBuilder는 출력 결과를 저장하므로 최대 O(N)의 공간 사용
         - 따라서 전체 공간복잡도는 O(N)



### ✨ 새롭게 배운 점
1. LinkedList의 특성 이해
- LinkedList가 큐 구현에 적합한 이유
- LinkedList의 메서드별 시간복잡도 차이


2. Java Collection Framework의 활용
- 문제 요구사항에 맞게 적절한 자료구조 선택하는 방법
- 자료구조의 메서드별 특성과 성능 고려


### 💡 성능 개선 포인트
1. LinkedList 말고도 ArrayDeque 사용으로 최적화 가능
- 성능 면에서: ArrayDeque는 배열 기반으로 구현되어 있어 메모리 지역성(locality)이 더 좋고, LinkedList보다 일반적으로 더 빠름.
- 목적에 적합한지: ArrayDeque는 큐와 스택 연산을 위해 특별히 설계되었고 큐 연산(offer, poll, peek)에 최적화되어 있음.
- 연산 시간복잡도 면에서:
  - ArrayDeque의 addLast()/offer(): O(1) 평균 시간복잡도
  - ArrayDeque의 removeFirst()/poll(): O(1) 평균 시간복잡도
  - ArrayDeque의 getFirst()/peek(): O(1) 평균 시간복잡도
  - ArrayDeque의 getLast()/peekLast(): O(1) 평균 시간복잡도
- 메모리 효율성 면에서: LinkedList는 각 노드마다 다음/이전 노드를 가리키는 참조가 필요하므로, 실제 데이터 외에 추가 메모리를 사용함 <-> ArrayDeque는 필요할 때만 배열 크기를 조정하므로 상대적으로 메모리 효율적

    #### 큐 연산만 수행하는 이 문제의 성격을 고려할 때, ArrayDeque는 LinkedList보다 더 적합한 자료구조이다. 특히 명령어 수가 최대 2,000,000개까지 가능하므로, 성능 차이가 눈에 띌 정도로 발생한다.