package baekjoon.silver.rope_2217;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int maxSum = 0;
        ArrayList<Integer> weightList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int weight = Integer.parseInt(br.readLine());
            weightList.add(weight);
        }
        Collections.sort(weightList);

        // 중량을 나눈다면
        for (int i = 0; i < weightList.size(); i++) {
            int sum = weightList.get(i) * (weightList.size() - i);
            if (sum > maxSum) {
                maxSum = sum;
            }
        }
        // 하나의 중량 자체가 더 클 수도 있으니
        for (Integer weight : weightList) {
            if (weight > maxSum) {
                maxSum = weight;
            }
        }
        System.out.println(maxSum);
    }
}