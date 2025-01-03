package programmers.level0.math.count_of_ordered_pairs;

class Solution {
    public int solution(int n) {
        int answer = 0;

    //         for (int a = 1; a <= n; a++) {
    //             for (int b = 1; b <= n; b++) {
    //                 if (a * b == n) {
    //                     answer++;
    //                 }

    //             }
    //         }

        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                answer++;
            }
        }

        return answer;
    }
}