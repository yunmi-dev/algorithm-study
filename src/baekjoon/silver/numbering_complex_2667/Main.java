package baekjoon.silver.numbering_complex_2667;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int[][] graph = new int[T][T];
        boolean[][] visited = new boolean[T][T];

        for (int row = 0; row < T; row++) {
            String line = br.readLine();
            for (int col = 0; col < T; col++) {
                graph[row][col] = line.charAt(col) - '0'; // 못풀었던 포인트, 0은 47 1은 48로 입력됐었음.
            }
        }

        ArrayList<Integer> apartsCount = new ArrayList<>();

        for (int row = 0; row < T; row++) {
            for (int col = 0; col < T; col++) {
                if (!visited[row][col] && graph[row][col] == 1) {
                    int[] index = {row, col};
                    apartsCount.add(bfs(index, graph, visited));
                }
            }
        }
        int complexesCount = apartsCount.size();
        System.out.println(complexesCount);
        Collections.sort(apartsCount);
        for (Integer count : apartsCount) {
            System.out.println(count);
        }
    }

    static int bfs(int[] index, int[][] graph, boolean[][] visited) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(index);
        int apartCount = 1;
        visited[index[0]][index[1]] = true;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];

                if (nx < 0 || nx >= graph[0].length || ny < 0 || ny >= graph[0].length) { continue; }

                if (!visited[nx][ny] && graph[nx][ny] == 1) {
                    queue.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    apartCount++;
                }
            }
        }
        return apartCount;
    }
}