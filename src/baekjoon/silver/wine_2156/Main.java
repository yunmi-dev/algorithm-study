package baekjoon.silver.wine_2156;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] wines = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            wines[i] = Integer.parseInt(br.readLine());
        }
        int result = 0;
        if (n == 1) {
            result = wines[1];
        } else if (n == 2) {
            result = wines[1] + wines[2];
        } else {

            // 다이나믹 프로그래밍
            int[][] dp = new int[n + 1][3];
            dp[1][0] = 0;
            dp[1][1] = wines[1];
            dp[2][0] = wines[1];
            dp[2][1] = wines[2];
            dp[2][2] = wines[1] + wines[2];


            for (int i = 3; i <= n; i++) {
//            dp[i][0] = dp[i-1][2];
//            dp[i][1] = dp[i-1][0] + wines[i];
//            dp[i][2] = dp[i-1][1] + wines[i];
                dp[i][0] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][1], dp[i - 1][2])); // 직전 와인까지를 고려했던 상태를 그대로 가져옴
                dp[i][1] = Math.max(dp[i - 2][0], Math.max(dp[i - 2][1], dp[i - 2][2])) + wines[i];
                dp[i][2] = Math.max(dp[i - 3][0], Math.max(dp[i - 3][1], dp[i - 3][2])) + wines[i - 1] + wines[i];
            }
            result = Math.max(dp[n][0], Math.max(dp[n][1], dp[n][2]));
        }
            bw.write(String.valueOf(result));
            bw.flush();
            bw.close();
    }
}