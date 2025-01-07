package programmers.level0.find_mode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

class Solution {
    public int solution(int[] array) {
        ArrayList<Integer> list  = new ArrayList<>();

        for (int a : array) {
            list.add(a);
        }

        int max = 0;
        for (Integer i : list) {
            int count = Collections.frequency(list, i);
            if (count > max) { max = count; }
        }
        HashSet<Integer> results = new HashSet<>();
        for (Integer i : list) {
            if (Collections.frequency(list, i) == max) { results.add(i); }
        }
        if (results.size() == 1) {
            return results.iterator().next();
        } else {
            return -1;
        }
    }
}