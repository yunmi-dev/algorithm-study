package baekjoon.bronze.word_study_1157;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String word = br.readLine();
        word = word.toUpperCase();

        int[] counts = new int[26];
        for (char ch : word.toCharArray()) {
            int index = ch - 'A';
            counts[index] += 1;
        }

        int maxIndex = 0;
        int maxCount = counts[0];
        boolean isDuplicate = false;

        for (int i = 1; i < counts.length; i++) {
            if (counts[i] > maxCount) {
                maxCount = counts[i];
                maxIndex = i;
                isDuplicate = false;
            }
            else if (counts[i] == maxCount) {
                isDuplicate = true;
            }
        }

        if (isDuplicate) {
            System.out.println("?");
        } else {
            char result = (char) (maxIndex + 'A');
            System.out.println(result);
        }
    }
}