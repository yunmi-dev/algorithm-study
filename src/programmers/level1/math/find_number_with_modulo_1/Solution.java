package programmers.level1.math.find_number_with_modulo_1;

class Solution {
    public int solution(int n) {
        int result = n;
        for (int i = 2; i < n; i++) {
            if ((n % i) == 1) {
                if (i < result) {
                    result = i;
                }
            }
        }
        return result;
    }
}