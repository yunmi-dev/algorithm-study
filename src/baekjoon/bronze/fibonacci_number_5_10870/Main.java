package baekjoon.bronze.fibonacci_number_5_10870;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] fibo = new int[21];
        fibo[0] = 0;
        fibo[1] = 1;
        for (int i = 2; i <= n; i++) {
            fibo[i] = fibo[i-2] + fibo[i-1];
        }
        bw.write(String.valueOf(fibo[n]));
        bw.flush();
        bw.close();
    }
}