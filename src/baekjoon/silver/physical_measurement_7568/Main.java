package baekjoon.silver.physical_measurement_7568;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[][] physical = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            physical[i][0] = Integer.parseInt(st.nextToken());
            physical[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            int count = 1;
            for (int j = 0; j < N; j++) {
                if (physical[i][0] < physical[j][0] && physical[i][1] < physical[j][1]) {
                    count++;
                }
            }
            sb.append(count).append(' ');
        }
        System.out.println(sb);
    }
}