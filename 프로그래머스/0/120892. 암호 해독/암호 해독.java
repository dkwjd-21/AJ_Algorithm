class Solution {
    public String solution(String cipher, int code) {
        String answer = "";
        cipher = " " + cipher;
        
        for(int i=1; i*code<cipher.length(); i++) {
            answer += cipher.charAt(i*code);
        }
        
        
        return answer;
    }
}