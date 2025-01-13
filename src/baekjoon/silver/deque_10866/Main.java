package baekjoon.silver.deque_10866;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedList<Integer> deque = new LinkedList<>();
        ArrayList<Integer> results = new ArrayList<>();

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            int X;

            switch (command) {
                case "push_front":
                    X = Integer.parseInt(st.nextToken());
                    deque.add(0, X);
                    break;
                case "push_back":
                    X = Integer.parseInt(st.nextToken());
                    deque.add(deque.size(), X);
                    break;
                case "pop_front":
                    if (deque.isEmpty()) {
                        results.add(-1);
                    } else {
                        results.add(deque.remove(0));
                    } break;
                case "pop_back":
                    if (deque.isEmpty()) {
                        results.add(-1);
                    } else {
                        results.add(deque.remove(deque.size() - 1));
                    } break;
                case "size":
                    results.add(deque.size());
                    break;
                case "empty":
                    if (deque.isEmpty()) {
                        results.add(1);
                    } else {
                        results.add(0);
                    } break;
                case "front":
                    if (deque.isEmpty()) {
                        results.add(-1);
                    } else {
                        results.add(deque.get(0));
                    } break;
                case "back":
                    if (deque.isEmpty()) {
                        results.add(-1);
                    } else {
//                        results.add(deque.peek());
                        results.add(deque.get(deque.size() - 1));
                    } break;
            }
        }
        for (Integer result : results) {
            System.out.println(result);
        }
    }
}