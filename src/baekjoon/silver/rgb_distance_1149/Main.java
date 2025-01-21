package baekjoon.silver.rgb_distance_1149;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] costs = new int[N + 1][3];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            costs[i][0] = Integer.parseInt(st.nextToken()); // R
            costs[i][1] = Integer.parseInt(st.nextToken()); // G
            costs[i][2] = Integer.parseInt(st.nextToken()); // B
        }

        // dp[i][R/G/B]를 i번째 집을 R/G/B로 칠했을때의 최소비용이라고 하자. (DP 시도)
        int[][] dp = new int[N + 1][3];
        dp[1][0] = costs[1][0];
        dp[1][1] = costs[1][1];
        dp[1][2] = costs[1][2];

//        dp[2][0] = costs[2][0] + Math.min(dp[1][1], dp[1][2]);
//        dp[2][1] = costs[2][1] + Math.min(dp[1][0], dp[1][2]);
//        dp[2][2] = costs[2][2] + Math.min(dp[1][0], dp[1][1]);

        for (int i = 2; i <= N; i++) {
            dp[i][0] = costs[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
            dp[i][1] = costs[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
            dp[i][2] = costs[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
        }

        int result = Math.min(dp[N][0], Math.min(dp[N][1], dp[N][2]));

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}