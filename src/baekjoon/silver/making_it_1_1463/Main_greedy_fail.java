package baekjoon.silver.making_it_1_1463;

import java.io.*;

public class Main_greedy_fail {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int x = 1, count = 0;
        while (x != N) {
            if (3 * x <= N) {
                x *= 3;
            } else if (2 * x <= N) {
                x *= 2;
            } else {
                x += 1;
            } count++;
        }
        System.out.println(count);
    }
}