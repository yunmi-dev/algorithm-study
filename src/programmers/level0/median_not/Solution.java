package programmers.level0.median;

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

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = {1, 2, 7, 10, 11};
        int[] arr2 = {-1, -2, 9};
        System.out.println(sol.solution(arr2));
    }
}