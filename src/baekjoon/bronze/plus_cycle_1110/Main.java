package baekjoon.bronze.plus_cycle_1110;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int N = Integer.parseInt(input);

        int current = N;
        int result = 0;

        while (current != N || result == 0) {
            String currentt = Integer.toString(current);
            if (currentt.length() == 1) {
                currentt = "0" + currentt;
            }

            char input1 = currentt.charAt(0);
            char input2 = currentt.charAt(1);
            int sum = (input1 - '0' + input2 - '0');
            String summ = Integer.toString(sum);
            if (summ.length() == 1) {
                current = Integer.parseInt(input2 + summ);
            } else {
                current = Integer.parseInt(input2 + String.valueOf(summ.charAt(1)));
            }
            result++;
        }

        System.out.println(result);
    }
}