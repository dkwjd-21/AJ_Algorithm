class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        
        // 길이가 4혹은 6
        if(s.length() != 4 && s.length() != 6) return false; 
        
        // 숫자로만 구성 
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if(ch < '0' || ch > '9') {
                answer = false;
                break;
            }
        }
        
        return answer;
    }
}