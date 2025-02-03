package baekjoon.bronze.sum_of_numbers_11720;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String numbers = br.readLine();

        int result = 0;
        for (char number : numbers.toCharArray()) {
            result += Integer.parseInt(String.valueOf(number));
        }
        System.out.println(result);
    }
}