package baekjoon.silver.two_sum_3273;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력받기 위한 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // n 입력받기
        int n = Integer.parseInt(br.readLine());

        // 공백으로 구분된 숫자들 입력받기
        HashSet<Integer> set = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        // x 입력받기
        int x = Integer.parseInt(br.readLine());


        int count = 0;
//        for(int i = 0; i < n-1; i++) {
//            for(int j = i+1; j < n; j++) {
//                if(arr[i] + arr[j] == x) {
//                    count++;
//                }
//            }
//        }

        for(int num : set) {
            // x-num이 set에 있고, 그 수가 현재 num과 다른 경우
            if(set.contains(x - num) && x - num != num) {
                count++;
            }
        }

        // 각 쌍이 2번씩 카운트되므로 2로 나눔
        System.out.println(count / 2);
    }
}