package programmers.level0.string.remove_vowels;

class Solution {
    public String solution(String my_string) {
        StringBuilder sb = new StringBuilder();

        for (char ch : my_string.toCharArray()) {
            if (ch != 'a' && ch != 'e' && ch != 'i' && ch != 'o' && ch != 'u') {
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}