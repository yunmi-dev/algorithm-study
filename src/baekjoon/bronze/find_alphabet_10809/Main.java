package baekjoon.bronze.find_alphabet_10809;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        StringBuilder sb = new StringBuilder();

        for (char i = 'a'; i <= 'z'; i++) {
            sb.append(S.indexOf(i)).append(' ');
        }

        System.out.println(sb);
    }
}