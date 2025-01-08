package programmers.level0.array.rotating_array;

import java.util.ArrayList;

class Solution {
    public int[] solution(int[] numbers, String direction) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int number : numbers) {
            list.add(number);
        }

        if (direction.equals("right")) {
            int removed = list.remove(list.size() - 1);
            list.add(0, removed);
        } else {
            int removed = list.remove(0);
            list.add(list.size(), removed);
        } return list.stream().mapToInt(i->i).toArray();
    }
}