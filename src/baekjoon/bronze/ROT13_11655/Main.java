package baekjoon.bronze.ROT13_11655;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringBuilder result = new StringBuilder();

        for (char ch : str.toCharArray()) {
            if (Character.isLetter(ch)) {
                if (Character.isUpperCase(ch)) {
                    ch = (char)((ch - 'A' + 13) % 26 + 'A'); // 대문자일 때
                } else {
                    ch = (char)((ch - 'a' + 13) % 26 + 'a'); // 소문자일 떄
                }
            }
            result.append(ch);
        }
        System.out.println(result.toString());
    }
}