package baekjoon.silver.editor_1406;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력 받기 위한 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫줄 String 입력받기
        String str = br.readLine();
        Stack<Character> leftStack = new Stack<>();
        Stack<Character> rightStack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            leftStack.push(str.charAt(i));
        }

        // 반복할 횟수 입력받기
        int iterCount = Integer.parseInt(br.readLine());

        for (int i = 0; i < iterCount; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()); // 명령어 줄마다 새로운 StringTokenizer 만들어줘야함
            String command = st.nextToken(); // 첫번째 토큰은 명령어

            switch (command) {
                case "L":
                    if (!leftStack.empty()) {
                        Character c = leftStack.pop();
                        rightStack.push(c);
                    }
                    break;
                case "D":
                    if (!rightStack.empty()) {
                        Character c = rightStack.pop();
                        leftStack.push(c);
                    }
                    break;
                case "B":
                    if (!leftStack.empty()) {
                        leftStack.pop();
                    }
                    break;
                case "P":
                    Character plusElement = st.nextToken().charAt(0);
                    leftStack.push(plusElement);
                    break;
                default:
                    break;
            }
        }

        // StringBuilder로 출력 최적화
        StringBuilder sb = new StringBuilder();

        // leftStack 출력
        for(char c : leftStack) {
            sb.append(c);
        }

        // rightStack 역순 출력
        while(!rightStack.empty()) {
            sb.append(rightStack.pop());
        }

        System.out.println(sb);
    }
}