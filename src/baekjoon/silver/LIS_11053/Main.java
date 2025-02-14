package baekjoon.silver.LIS_11053;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] sequence = new int[N + 1];
        int[] dp = new int[N + 1]; // 해당 번째까지 가장 긴 수열의 길이

        for (int i = 1; i <= N; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Integer> firstList = new ArrayList<>();

        dp[1] = 1;
        firstList.add(1);

        for (int i = 2; i <= N; i++) {
            if (sequence[i] > sequence[i - 1]) {

            }
        }

    }
}