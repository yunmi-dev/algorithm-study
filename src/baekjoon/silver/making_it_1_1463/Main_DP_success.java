package baekjoon.silver.making_it_1_1463;

import java.io.*;

public class Main_DP_success {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] memo = new int[N + 1]; // 메모이제이션을 위해 (중복되는 연산 너무 많아서)
        memo[1] = 0;
        /*
        memo[2] = 1;
        memo[3] = 1; // 1, 2, 3 일때의 최솟값만 정의해주면 될까?
         */

        if (N >= 2) memo[2] = 1;
        if (N >= 3) memo[3] = 1;
        // N이 1이나 2일 때 memo[2]나 memo[3]에 접근하려면 ArrayIndexOutOfBoundsException 날 수 있음 (컴파일 에러의 원인)


        for (int i = 4; i <= N; i++) {
            int count1 = 0, count2 = 0, count3 = 0;
            if (i % 3 == 0) {
                int case1 = i / 3;
                count1 = memo[case1] + 1;
            }
            if (i % 2 == 0) {
                int case2 = i / 2;
                count2 = memo[case2] + 1;
            }
            int case3 = i - 1;
            count3 = memo[case3] + 1;
            if (count1 == 0) { count1 = count3; }
            if (count2 == 0) { count2 = count3; }
            memo[i] = Math.min(Math.min(count1, count2), count3);
        }
        System.out.println(memo[N]);
    }
}