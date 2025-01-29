package baekjoon.bronze.finding_prime_numbers_1978;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int result = 0;
        for (int i = 0; i < N; i++) {
            int k = Integer.parseInt(st.nextToken());
            if (k == 1) {
                continue;
            }
            boolean isPrime = true;
            for (int num = 2; num < k; num++) {
                if (k % num == 0) {
                    isPrime = false;
                }
            }
            if (isPrime) {
                result += 1;
            }
        }
        System.out.println(result);
    }
}