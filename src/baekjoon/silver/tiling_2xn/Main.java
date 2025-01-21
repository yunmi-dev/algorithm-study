package baekjoon.silver.tiling_2xn;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int result = 0;

        if (n == 1) {
            result = 1;
        } else if (n == 2) {
            result = 2;
        } else {
            int[] dp = new int[n + 1];
            dp[1] = 1;
            dp[2] = 2;
            for (int i = 3; i <= n; i++) {
                dp[i] = (dp[i - 1] + dp[i - 2]) % 10007; // 오버플로우 방지를 위해 계산할 때마다 나머지 조작
            }
            result = dp[n];
        }
//        result %= 10007;
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}