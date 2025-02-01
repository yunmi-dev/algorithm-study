package baekjoon.silver.movie_director_shom_1436;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int sequence = 0;
        int intCurrent = 665;

        while (sequence != N) {
            intCurrent++;
            String strCurrent = Integer.toString(intCurrent);
            if (strCurrent.contains("666")) {
                sequence++;
            }
        }
        System.out.println(intCurrent);
    }
}