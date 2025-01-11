package programmers.level0.array.find_median;

import java.util.ArrayList;

class Solution {
    public int solution(int[] array) {

        ArrayList<Integer> list = new ArrayList<>();
        for (int a : array) {
            list.add(a);
        }
        list.sort(null);

        return list.get(array.length / 2);
    }
}