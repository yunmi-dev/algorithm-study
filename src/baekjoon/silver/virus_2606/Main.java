package baekjoon.silver.virus_2606;

import java.io.*;
import java.util.*;

public class Main {
    static int result = 0; // 1번 컴퓨터는 카운팅에 포함 안됨

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 컴퓨터 수
        int m = Integer.parseInt(br.readLine()); // 연결된 컴퓨터 쌍의 수

        int[][] graph = new int[n+1][n+1];
        boolean[] visited = new boolean[n+1];

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a][b] = 1;
            graph[b][a] = 1;
        } // 그래프 세팅

        dfs(1, graph, visited);
        System.out.println(result);
    }

    static void dfs(int index, int[][] graph, boolean[] visited) {
        visited[index] = true;

        for (int i = 0; i < graph.length; i++) {
            if (!visited[i] && graph[index][i] == 1) {
                result++;
                dfs(i, graph, visited);
            }
        }
    }
}