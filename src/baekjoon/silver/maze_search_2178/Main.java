package baekjoon.silver.maze_search_2178;

import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int N, M;
    static int[][] maze;
    static int[][] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        maze = new int[N][M];
        distance = new int[N][M];

        for (int row = 0; row < N; row++) {
            String line = br.readLine();
            for (int col = 0; col < M; col++) {
                maze[row][col] = line.charAt(col) - '0'; // char를 정수로 가져오기 위해
                // '1' - '0' = 49 - 48 = 1 이런식으로 실제 정수값을 얻음
            }
        } // 여기까지 2차원 배열 미로 저장

        // BFS...
        bfs();

        System.out.println(distance[N - 1][M - 1]);
    }

    static void bfs() {
        Queue<int[]> queue = new LinkedList<>();

        // 시작점 처리 - 항상 (0, 0) 에서 시작함
        queue.offer(new int[]{0, 0});
        distance[0][0] = 1;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

                if (distance[nx][ny] == 0 && maze[nx][ny] == 1) {
                    distance[nx][ny] = distance[current[0]][current[1]] + 1;  // 이전 위치의 거리 + 1
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
    }
}