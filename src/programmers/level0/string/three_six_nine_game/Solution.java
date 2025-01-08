package programmers.level0.string.three_six_nine_game;

class Solution {
    public int solution(int order) {

        int count = 0;
        String strOrder = String.valueOf(order);
        for (int i = 0; i < strOrder.length(); i++) {
            char ch = strOrder.charAt(i);
            if (ch == '3' || ch == '6' || ch == '9') {
                count++;
            }
        }
        return count;
    }
}