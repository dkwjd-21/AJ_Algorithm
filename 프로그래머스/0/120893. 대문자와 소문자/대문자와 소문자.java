class Solution {
    public String solution(String my_string) {
        String answer = "";
        char tmp;
        
        for(int i=0; i<my_string.length(); i++) {
            tmp = my_string.charAt(i);
            
            if(tmp <= 'Z') {
                answer += (tmp+"").toLowerCase();
            } else {
                answer += (tmp+"").toUpperCase();
            }
            
            
        }
        
        
        return answer;
    }
}