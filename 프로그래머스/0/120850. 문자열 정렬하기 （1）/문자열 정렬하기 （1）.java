import java.util.*;

class Solution {
    public ArrayList<Integer> solution(String my_string) {
        // int[] answer = {};
        ArrayList<Integer> answer = new ArrayList<Integer>();
        
        for(int i=0; i<my_string.length(); i++) {
            char tmp = my_string.charAt(i);
            
            // isDigit : 주어진 char 값이 '0'부터 '9' 사이의 숫자인지 판별
            if(Character.isDigit(tmp)) {
                answer.add(Integer.parseInt(tmp+""));
            }
        }
        
        Collections.sort(answer);
        
        return answer;
    }
}