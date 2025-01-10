package baekjoon.silver.picture_1926;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        if (n <= 0 || m <= 0) {
            return;
        }

        int[][] pictures = new int[n][m];
        boolean[][] visited = new boolean[n][m];

        for (int row = 0; row < n; row++) {
            st = new StringTokenizer(br.readLine());
            for (int col = 0; col < m; col++) {
                pictures[row][col] = Integer.parseInt(st.nextToken());
            }
        } // 여기까지 2차원 배열 그림 저장


        // BFS...
        int area = 0;

        ArrayList<Integer> areas = new ArrayList<>();

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (!visited[row][col] && pictures[row][col] == 1) {
                    int[] index = new int[]{row, col};
                    area = bfs(index, pictures, visited);
                    areas.add(area);
                }
            }
        }
        int pictureCount = areas.size();
        System.out.println(pictureCount);
        if (pictureCount == 0) {
            System.out.println(0);
        } else {
            System.out.println(Collections.max(areas));
        }
    }

    static int bfs(int[] index, int[][] pictures, boolean[][] visited) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(index);
        visited[index[0]][index[1]] = true; // 첫 방문 처리 깜빡함
        int area = 1;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            int[] dx = {-1, 1, 0, 0};
            int[] dy = {0, 0, -1, 1};

            for (int i = 0; i < 4; i++) {
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];

                if (nx < 0 || nx >= pictures.length || ny < 0 || ny >= pictures[0].length) { continue; }

                if (!visited[nx][ny] && pictures[nx][ny] == 1) {
                    queue.offer(new int[]{nx, ny});
//                    visited[nx][ny] = true;
                    area++;
                }
                visited[nx][ny] = true;
            }
        }

        return area;
    }
}