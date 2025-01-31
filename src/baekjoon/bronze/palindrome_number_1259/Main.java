package baekjoon.bronze.palindrome_number_1259;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String input = br.readLine();
            if (input.equals("0")) {
                bw.write(String.valueOf(sb));
                bw.flush();
                bw.close();
                return;
            } // 0 입력되면 종료

            String reversed = new StringBuilder(input).reverse().toString();
            if (input.equals(reversed)) {
                sb.append("yes").append('\n');
            } else {
                sb.append("no").append('\n');
            }
        }
    }
}