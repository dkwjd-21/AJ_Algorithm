class Solution {
    public int solution(String my_string) {
        // my_string 안의 모든 자연수들의 합을 리턴 
        int answer = 0;
        
        for(int i=0; i<my_string.length(); i++) {
            char tmp = my_string.charAt(i);
            
            if(Character.isDigit(tmp)) {
                answer += Integer.parseInt(tmp+"");
            }
            
        }
        
        return answer;
    }
}