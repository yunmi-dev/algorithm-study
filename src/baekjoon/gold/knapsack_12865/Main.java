package baekjoon.gold.knapsack_12865;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    static int[][] WV;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 물품의 수 N
        int K = Integer.parseInt(st.nextToken()); // 버틸 수 있는 무게 K

        WV = new int[N+1][2];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            WV[i][0] = Integer.parseInt(st.nextToken());
            WV[i][1] = Integer.parseInt(st.nextToken());
        } // 여기까지 WV 세팅

        LinkedList<int[]> dividendList = new LinkedList<>();
        bw.write(String.valueOf(getDP(N, K, dividendList)));
        bw.flush();
        bw.close();
    }

    public static int getDP(int N, int K, LinkedList<int[]> dividendList) {
        int[][] DP = new int[N+1][2];

        DP[1][0] = WV[1][0];
        DP[1][1] = WV[1][1];
        dividendList.add(WV[1]);
        for (int i = 2; i <= N; i++) {
            if (DP[i-1][0] + WV[i][0] > K) {
                // 끝에 하나 추가함으로써 무게를 초과한다면...

                LinkedList<int[]> list = new LinkedList<>();
                if (getDP(dividendList.size(), WV[i][0], list) < WV[i][1]) {
                    DP[i][0] = DP[i - 1][0];
                    DP[i][1] = DP[i - 1][1];
                    for (int[] wv : list) {
                        dividendList.remove(wv);
                        DP[i][0] -= wv[0];
                        DP[i][1] -= wv[1];
                    }
                    dividendList.add(new int[]{WV[i][0], WV[i][1]});
                }
            } else {
                DP[i][0] = DP[i - 1][0] + WV[i][0];
                DP[i][1] = DP[i - 1][1] + WV[i][1];
                dividendList.add(WV[i]);
            }
        }
        return DP[N][1];
    }
}