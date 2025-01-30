package baekjoon.bronze.gcd_and_lcm_2609;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int smallNum = Math.min(a, b);
        int bigNum = Math.max(a, b);

        // 최대공약수
        for (int gcd = smallNum; gcd > 0; gcd--) {
            if (smallNum % gcd == 0 && bigNum % gcd == 0) {
                System.out.println(gcd);
                break;
            }
        }

        // 최소공배수
        int i = 1;
        while (true) {
            int lcm = smallNum * i++;
            if (lcm % bigNum == 0) {
                System.out.println(lcm);
                break;
            }
        }
    }
}