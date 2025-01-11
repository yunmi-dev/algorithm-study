package baekjoon.silver.cabbage_clusters_1012;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        ArrayList<Integer> results = new ArrayList<>();

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken()); // 배추밭 가로 길이
            int N = Integer.parseInt(st.nextToken()); // 배추밭 세로 길이
            int K = Integer.parseInt(st.nextToken()); // 배추 심어진 개수

            if (M == 0 || N == 0 || K == 0) {
                System.out.println(0);
                continue;
            }

            int[][] graph = new int[M][N];
            boolean[][] visited = new boolean[M][N];

            for (int j = 0; j < K; j++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                graph[x][y] = 1;
            }

            int result = 0;
            for (int row = 0; row < M; row++) {
                for (int col = 0; col < N; col++) {
                    if (!visited[row][col] && graph[row][col] == 1) {
                        dfs(new int[]{row, col}, graph, visited);
                        result++;
                    }
                }
            }
            results.add(result);
        }
        for (Integer r : results) {
            System.out.println(r);
        }
    }

    static void dfs(int[] index, int[][] graph, boolean[][] visited) {
        visited[index[0]][index[1]] = true;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int i = 0; i < 4; i++) {
            int nx = index[0] + dx[i];
            int ny = index[1] + dy[i];

            if (nx < 0 || nx >= graph.length || ny < 0 || ny >= graph[0].length) { continue; }

            if (!visited[nx][ny] && graph[nx][ny] == 1) {
                dfs(new int[]{nx, ny}, graph, visited);
            }
        }
    }
}