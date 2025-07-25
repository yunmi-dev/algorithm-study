package baekjoon.silver.sugar_delivery_2839;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int min = -1;
        for (int fiveCount = N / 5; fiveCount >= 0; fiveCount--) {
            if ((N - fiveCount * 5) % 3 == 0) {
                int threeCount = (N - fiveCount * 5) / 3;
                min = fiveCount + threeCount;
                break;
            }
        }
        System.out.println(min);
    }
}