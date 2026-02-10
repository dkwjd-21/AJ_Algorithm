class Solution {
    public String solution(String my_string, int n) {
        String answer = "";
        
        // my_string에 들어있는 각 문자를 n만큼 반복한 문자열 return 
        for(int i=0; i<my_string.length(); i++) {
            char tmp = my_string.charAt(i);
            answer += (tmp+"").repeat(n);
        }
        
        return answer;
    }
}