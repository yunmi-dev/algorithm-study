package baekjoon.silver.stack_sequence_1874;

import java.io.*;
import java.util.*;

public class Main_Timeout {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> history = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        boolean isValid = true;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            int k = Integer.parseInt(br.readLine());
            while (true) {
                if (stack.isEmpty()) {
                    stack.push(1);
                    sb.append("+").append('\n');
                } else if (stack.peek() < k) {
                    for (int y = stack.peek() + 1; y <= k; y++) {
                        if (!history.contains(y)) { // O(n) 소요
                            stack.push(y);
                            sb.append("+").append('\n');
                        }
                    }
                } else if (!stack.isEmpty() && stack.peek() == k) {
                    history.add(stack.pop());
                    sb.append("-").append('\n');
                    break;
                } else {
                    isValid = false;
                    break;
                }
            }
        }
        System.out.println(isValid ? sb : "NO");
    }
}