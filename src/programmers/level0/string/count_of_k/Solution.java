package programmers.level0.string.count_of_k;

class Solution {
    public int solution(int i, int j, int k) {
        int count = 0;
        for (int num = i; num <= j; num++) {
            String strNum = String.valueOf(num);
            char charK = (char) (k + '0'); // int형인 숫자를 그대로 char형으로 표현하는 법
            for (int s = 0; s < strNum.length(); s++) {
                if (strNum.charAt(s) == charK) {
                    count++;
                }
            }
        }
        return count;
    }
}