package baekjoon.silver.balanced_world_4949;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> results = new ArrayList<>();

        String str = br.readLine();
        while (!str.equals(".")) {
            Stack<Character> stack = new Stack<>();
            boolean hasBracket = false;
            boolean isValid = true;

            for (char ch : str.toCharArray()) {
                if (ch == '(' || ch == '[') {
                    stack.push(ch);
                    hasBracket = true;
                } else if (ch == ')') {
                    if (!stack.isEmpty() && stack.peek() == '(') { // 빈 스택에 peek 쓰면 예외오류
                        stack.pop();
                    } else {
                        isValid = false;
                    }
                } else if (ch == ']') {
                    if (!stack.isEmpty() && stack.peek() == '[') {
                        stack.pop();
                    } else {
                        isValid = false;
                    }
                }
            }
            if (!isValid) {
                results.add("no");
            } else if (!hasBracket) {
                results.add("yes");
            } else if (stack.isEmpty()) {
                results.add("yes");
            } else {
                results.add("no");
            }
            str = br.readLine();
        }
        for (String result : results) {
            System.out.println(result);
        }
    }
}