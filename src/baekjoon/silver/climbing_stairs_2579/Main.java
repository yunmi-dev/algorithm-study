package baekjoon.silver.climbing_stairs_2579;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine()); // 계단의 수
        int[] scores = new int[301];

        for (int i = 1; i <= N; i++) {
            int score = Integer.parseInt(br.readLine());
            scores[i] = score;
        } // 각 계단의 점수 입력받기

        int[] memo = new int[301]; // 중간결과 저장해서 활용할거임
        memo[1] = scores[1];
        memo[2] = scores[1] + scores[2];
        memo[3] = Math.max(scores[1], scores[2]) + scores[3];
        for (int i = 4; i <= N; i++) {
            memo[i] = Math.max((memo[i - 3] + scores[i - 1] + scores[i]), (memo[i - 2] + scores[i]));
        }

        sb.append(memo[N]);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}