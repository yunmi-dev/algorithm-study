package programmers.level1.string.numbers_spaced_by_x;

class Solution {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        long k = x;
        for (int i = 0; i < n; i++) {
            answer[i] = k;
            k += x;
        }
        return answer;
    }
}