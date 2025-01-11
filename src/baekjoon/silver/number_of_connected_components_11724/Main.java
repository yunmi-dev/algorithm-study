package baekjoon.silver.number_of_connected_components_11724;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 노드 개수
        int M = Integer.parseInt(st.nextToken()); // 간선 개수

        int[][] graph = new int[N+1][N+1]; // 1-based
        boolean[] visited = new boolean[N+1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        int result = 0;
        for (int i = 1; i < N+1; i++) {
            if (!visited[i]) {
                result++;
                dfs(i, graph, visited);
            }
        }
        System.out.println(result);
    }

    static void dfs(int index, int[][] graph, boolean[] visited) {
        visited[index] = true;
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i] && graph[index][i] == 1) {
                dfs(i, graph, visited);
            }
        }
    }
}