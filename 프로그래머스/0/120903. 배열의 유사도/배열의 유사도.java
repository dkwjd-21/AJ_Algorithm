import java.util.*;

class Solution {
    public int solution(String[] s1, String[] s2) {
        int answer = 0;
        
        ArrayList<String> s1List = new ArrayList<String>();
        for(int i=0; i<s1.length; i++) {
            s1List.add(s1[i]);
        }
        
        for(int i=0; i<s2.length; i++) {
            if(s1List.contains(s2[i])) answer++;
        }
        
        return answer;
    }
}