package baekjoon.silver.editor_1406;

import java.io.*;
import java.util.*;

public class Main_Timeout {
    public static void main(String[] args) throws IOException {
        // 입력 받기 위한 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫줄 String 입력받기
        String str = br.readLine();
        Stack<Character> strStack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            strStack.add(str.charAt(i));
        }
        int cursor = strStack.size();

        // 반복할 횟수 입력받기
        int iterCount = Integer.parseInt(br.readLine());

        for (int i = 0; i < iterCount; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()); // 명령어 줄마다 새로운 StringTokenizer 만들어줘야함
            String command = st.nextToken(); // 첫번째 토큰은 명령어

            switch (command) {
                case "L":
                    if (cursor != 0) {
                        cursor--;
                    }
                    break;
                case "D":
                    if (cursor != strStack.size()) {
                        cursor++;
                    }
                    break;
                case "B":
                    if (!strStack.empty() && cursor > 0) {
                        strStack.remove(cursor - 1);
                        cursor--;
                    }
                    break;
                case "P":
                    Character plusElement = st.nextToken().charAt(0);
                    strStack.add(cursor, plusElement);
                    cursor++;
                    break;
                default:
                    break;
            }
        }

        for (Character c : strStack) {
            System.out.print(c);
        }
    }
}