package baekjoon.silver.queue_2_18258;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "push":
                    linkedList.add(linkedList.size(), Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    if (linkedList.isEmpty()) {
                        sb.append(-1).append('\n');
                    } else {
                        sb.append(linkedList.remove(0)).append('\n');
                    } break;
                case "size":
                    sb.append(linkedList.size()).append('\n');
                    break;
                case "empty":
                    if (linkedList.isEmpty()) {
                        sb.append(1).append('\n');
                    } else {
                        sb.append(0).append('\n');
                    } break;
                case "front":
                    if (linkedList.isEmpty()) {
                        sb.append(-1).append('\n');
                    } else {
                        sb.append(linkedList.get(0)).append('\n');
                    } break;
                case "back":
                    if (linkedList.isEmpty()) {
                        sb.append(-1).append('\n');
                    } else {
                        sb.append(linkedList.get(linkedList.size() - 1)).append('\n');
                    } break;
            }
        }
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
    }
}