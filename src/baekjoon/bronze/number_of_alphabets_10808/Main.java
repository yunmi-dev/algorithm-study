package baekjoon.bronze.number_of_alphabets_10808;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.nextLine();

        int[] countAlphabets = new int[26];

        for (int i = 0; i < S.length(); i++) {
            char character = S.charAt(i);
            int ascii = (int) character;
//            System.out.println(ascii);
            countAlphabets[ascii - 97] += 1;
        }

        for (int count : countAlphabets) {
            System.out.print(count + " ");
        }
    }
}