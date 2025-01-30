package baekjoon.bronze.binomial_coefficient_1_11050;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int result = 1;
        for (int i = 0; i < K; i++) {
            result *= N - i;
        }
        for (int i = 1; i <= K; i++) {
            result /= i;
        }

        System.out.println(result);
    }
}