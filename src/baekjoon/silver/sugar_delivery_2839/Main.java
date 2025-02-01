package baekjoon.silver.sugar_delivery_2839;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int result = 0;

        int count3 = N / 3 + 1;
        int count5 = N / 5 + 1;

        int[][] numbers = new int[count3][count5];
        ArrayList<Integer> exists = new ArrayList<>();
        for (int row = 0; row < count3; row++) {
            for (int col = 0; col < count5; col++) {
                numbers[row][col] = 3 * row + 5 * col;
                if (numbers[row][col] == N) {
                    exists.add(row+col);
                }
            }
        }
        if (exists.isEmpty()) {
            System.out.println(-1);
        } else {
            System.out.println(Collections.min(exists));
        }

    }
}