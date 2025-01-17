package baekjoon.silver.coin_0_11047;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 화폐 종류 개수
        int K = Integer.parseInt(st.nextToken()); // 만들어야 할 액수
        int[] coinType = new int[N];

        for (int i = 0; i < N; i++) {
            coinType[i] = Integer.parseInt(br.readLine());
        }
        int count = 0;

        for (int i = N-1; i >= 0; i--) {
            while (K >= coinType[i]) {
                K -= coinType[i];
                count++;
            }
        }
        System.out.println(count);
    }
}