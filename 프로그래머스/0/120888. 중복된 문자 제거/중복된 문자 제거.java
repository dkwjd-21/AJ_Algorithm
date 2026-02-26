import java.util.*;

class Solution {
    public String solution(String my_string) {
        ArrayList<String> strList = new ArrayList<String>();
        String answer = "";
        
        for(int i=0; i<my_string.length(); i++) {
            String tmp = my_string.charAt(i) + "";
            
            if(strList.contains(tmp)) {
                continue;
            } else {
                strList.add(tmp);
                answer += tmp;
            }
        }
        
        return answer;
    }
}