package baekjoon.bronze.not_submitted_5597;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> submitted = new ArrayList<>();
        // 모든 출석번호 세팅
        for (int i = 1; i <= 30; i++) {
            submitted.add(i);
        }
        // 제출한 학생의 출석번호 삭제
        for (int i = 1; i <= 28; i++) {
            submitted.remove(Integer.valueOf(Integer.parseInt(br.readLine())));
        }
        // 미제출한 출석번호들 출력
        for (int s : submitted) {
            System.out.println(s);
        }
    }
}