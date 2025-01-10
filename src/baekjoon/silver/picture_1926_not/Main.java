package baekjoon.silver.picture_1926_not;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] pictures = new int[n][m];
        boolean[][] visited = new boolean[n][m];

        for (int row = 0; row < n; row++) {
            st = new StringTokenizer(br.readLine());
            for (int col = 0; col < m; col++) {
                pictures[row][col] = Integer.parseInt(st.nextToken());
            }
        } // 여기까지 2차원 배열 그림 저장

        // BFS...
        int pictureCount = 0, area = 0, maxArea = 0;


        // BFS용 큐
        Queue<int[]> bfsQueue = new LinkedList<>();
        // 방문 체크용 배열


//
//        for (int row = 0; row < n; row++){
//            for (int col = 0; col < m; col++)  {
//                if (visited[row][col] == false) {
//                    visited[row][col] = true;
//                    if (pictures[row][col] == 1) {
//                        bfsQueue.add(new int[]{row, col});
//                        if (visited[row+1][col] == false) {
//                            visited[row+1][col] = true;
//                            if (pictures[row+1]);
//                        }
//                    }
//                }
//            }
//        }
//
//        bfsQueue.add(pictures);
//    }
    }
}