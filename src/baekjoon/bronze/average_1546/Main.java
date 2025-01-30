package baekjoon.bronze.average_1546;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] scores = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            scores[i] = Integer.parseInt(st.nextToken());
        }
        int M = Arrays.stream(scores).max().getAsInt();

        double result = 0;
        for (int i = 0; i < N; i++) {
            result += (double) scores[i] / M * 100;
        }
        result /= N;
        System.out.println(result);

    }
}