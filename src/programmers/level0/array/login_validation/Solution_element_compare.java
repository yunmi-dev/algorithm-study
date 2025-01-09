package programmers.level0.login_validation;

class Solution_element_compare {
    public String solution(String[] id_pw, String[][] db) {
        String answer = "";

        for (String[] i : db) {
            if (i == id_pw) { // 주소값 비교를 하게 되므로 잘못된 풀이
                return "login";
            } else if (i[0].equals(id_pw[0])) {
                return "wrong pw";
            }
        }

        return "fail";
    }
}