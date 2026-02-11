class Solution {
    public String solution(int age) {
        // a=0, b=1, c=2 ... 
        // 23살 = cd, 51살 = fb
        StringBuilder answer = new StringBuilder();
        
        String newAge = age + "";
        for(int i=0; i<newAge.length(); i++) {
            char tmp = newAge.charAt(i);
            
            // 아스키코드 0 -> 48, a -> 97 
            // 각 자리수(char)에 49를 더하면 됨 
            answer.append((char) (tmp + 49));
        }
        
        return answer.toString();
    }
}