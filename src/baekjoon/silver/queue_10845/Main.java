package baekjoon.silver.queue_10845;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> results = new ArrayList<>();

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch (command) {
                case "push":
                    int X = Integer.parseInt(st.nextToken());
                    list.add(X);
                    break;
                case "pop":
                    if (list.isEmpty()) {
                        results.add(-1);
                    } else {
                        results.add(list.remove(0));
                    }
                    break;
                case "size":
                    results.add(list.size());
                    break;
                case "empty":
                    if (list.isEmpty()) {
                        results.add(1);
                    } else {
                        results.add(0);
                    } break;
                case "front":
                    if (list.isEmpty()) {
                        results.add(-1);
                    } else {
                        results.add(list.get(0));
                    } break;
                case "back":
                    if (list.isEmpty()) {
                        results.add(-1);
                    } else {
                        results.add(list.get(list.size() - 1));
                    } break;
            }
        }
        for (Integer result : results) {
            System.out.println(result);
        }
    }
}