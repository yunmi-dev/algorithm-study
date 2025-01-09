package programmers.level0.array.login_validation;

class Solution_element_compare {
    public String solution(String[] id_pw, String[][] db) {
        String answer = "";

        for (String[] dbInfo : db) {
            if (dbInfo[0].equals(id_pw[0]) && dbInfo[1].equals(id_pw[1])) {
                return "login";
            } else if (dbInfo[0].equals(id_pw[0])) {
                return "wrong pw";
            }
        }

        return "fail";
    }
}