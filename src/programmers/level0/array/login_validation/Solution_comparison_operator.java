package programmers.level0.array.login_validation;

class Solution_comparison_operator {
    public String solution(String[] id_pw, String[][] db) {
        String answer = "";

        for (String[] dbInfo : db) {
            if (dbInfo == id_pw) { // 주소값 비교를 하게 되므로 잘못된 풀이
                return "login";
            } else if (dbInfo[0].equals(id_pw[0])) {
                return "wrong pw";
            }
        }

        return "fail";
    }
}