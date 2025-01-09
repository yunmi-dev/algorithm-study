package programmers.level0.array.login_validation;

import java.util.Arrays;

class Solution_Arrays_equals {
    public String solution(String[] id_pw, String[][] db) {
        for (String[] dbInfo : db) {
            if (Arrays.equals(dbInfo, id_pw)) {
                return "login";
            } else if (dbInfo[0].equals(id_pw[0])) {
                return "wrong pw";
            }
        }
        return "fail";
    }
}