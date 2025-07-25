package baekjoon.silver.parenthesis_9012;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String PS = br.readLine();

            Stack<Character> stack = new Stack<>();
            for (char ch : PS.toCharArray()) {
                if (!stack.isEmpty() && stack.peek() == '(' && ch == ')') {
                    stack.pop();
                } else {
                    stack.push(ch);
                }
            }
            if (!stack.isEmpty()) {
                sb.append("NO").append('\n');
            } else {
                sb.append("YES").append('\n');
            }
        }
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
    }
}