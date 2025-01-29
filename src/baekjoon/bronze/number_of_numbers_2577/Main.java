package baekjoon.bronze.number_of_numbers_2577;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int number = 1;

        for (int i = 0; i < 3; i++) {
            number *= Integer.parseInt(br.readLine());
        }

        int[] counts = new int[10];
        String strNumber = Integer.toString(number);
        for (char ch : strNumber.toCharArray()) {
            int ascii = ch - '0';
            counts[ascii] += 1;
        }
        for (int count : counts) {
            sb.append(count).append('\n');
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}