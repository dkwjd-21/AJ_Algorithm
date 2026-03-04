import java.util.*;

class Solution {
    public String solution(String my_string) {
        String answer = "";
        
        my_string = my_string.toLowerCase();
        char[] strToChar = my_string.toCharArray();
        
        Arrays.sort(strToChar);
        
        answer = new String(strToChar);
        
        return answer;
    }
}