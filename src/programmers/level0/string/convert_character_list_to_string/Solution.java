package programmers.level0.string.convert_character_list_to_string;


class Solution {
    public String solution(String[] arr) {
        StringBuilder sb = new StringBuilder();

        for (String a : arr) {
            sb.append(a);
        }

        return sb.toString();
    }
}