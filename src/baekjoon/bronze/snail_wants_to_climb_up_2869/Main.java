package baekjoon.bronze.snail_wants_to_climb_up_2869;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        int current = A; // 첫날 낮에 올라감
        int result = 1;

        if ((V - current) % (A - B) == 0) {
            result += (V - current) / (A - B);
        } else {
            result += (V - current) / (A - B) + 1;
        }
        System.out.println(result);
    }
}