package baekjoon.silver.editor_1406.linkedlist;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력 받기 위한 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫줄 String 입력받기
        String str = br.readLine();
        LinkedList<Character> strLinkedlist = new LinkedList<>(); // LinkedList 생성
        ListIterator<Character> cursor = strLinkedlist.listIterator(strLinkedlist.size());
        for (int i = 0; i < str.length(); i++) {
            cursor.add(str.charAt(i)); // 시간복잡도 O(1)
            // strLinkedList.add(str.charAt(i))도 성능상 큰 차이는 없음
        }

        // 반복할 횟수 입력받기
        int iterCount = Integer.parseInt(br.readLine());

        for (int i = 0; i < iterCount; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()); // 명령어 줄마다 새로운 StringTokenizer 만들어줘야함
            String command = st.nextToken(); // 첫번째 토큰은 명령어

            switch (command) {
                case "L":
                    if (cursor.hasPrevious()) {
                        cursor.previous();
                    } break;
                case "D":
                    if (cursor.hasNext()) {
                        cursor.next();
                    } break;
                case "B":
                    if (cursor.hasPrevious()) {
                        cursor.previous(); // 최근에 지나친 요소 (내가 삭제할 대상)
                        cursor.remove(); // remove 메소드는 가장 최근에 지나치게 된 요소를 삭제함
                    } break;
                case "P":
                    Character plusElement = st.nextToken().charAt(0);
                    cursor.add(plusElement);
                    break;
                default:
                    break;
            }
        }

        // StringBuilder로 출력 최적화
        StringBuilder sb = new StringBuilder();

        // LinkedList 타입의 요소들 순서대로 출력
        for (Character c : strLinkedlist) {
            sb.append(c);
        }

        System.out.println(sb);
    }
}