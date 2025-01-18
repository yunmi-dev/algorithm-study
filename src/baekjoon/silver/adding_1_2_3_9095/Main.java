package baekjoon.silver.adding_1_2_3_9095;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수


        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] memo = new int[n + 1];

            memo[1] = 1;
            if (n >= 2) memo[2] = 2;
            if (n >= 3) memo[3] = 4;

            for (int j = 4; j <= n; j++) {
                memo[j] = memo[j - 3] + memo[j - 2] + memo[j - 1];
            }
            sb.append(memo[n]).append('\n');
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}