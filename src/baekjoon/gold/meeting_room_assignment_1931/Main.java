package baekjoon.gold.meeting_room_assignment_1931;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 회의의 수
        ArrayList<int[]> meetingList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] meetingTime = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            meetingList.add(meetingTime);
        }

        // 종료 시간 기준으로 정렬, 종료 시간이 같으면 시작 시간으로 정렬
        Collections.sort(meetingList, (a, b) -> {
            if (a[1] == b[1]) {
                return Integer.compare(a[0], b[0]);
            } return Integer.compare(a[1], b[1]); // 디폴트는 종료 시간 순으로
        }); //

        int count = 0;
        int lastEndTime = 0;

        for (int[] meeting : meetingList) {
            if (meeting[0] >= lastEndTime) {
                count++;
                lastEndTime = meeting[1];
            }
        }

        System.out.println(count);
    }
}