class Solution {
    public String[] solution(String my_str, int n) {
        int len = my_str.length() / n;
        len = (my_str.length() % n == 0)? len : len + 1;
        String[] answer = new String[len];

        StringBuffer sb = new StringBuffer(my_str);
        
        for(int i=0; i<answer.length; i++) {
            if(sb.length() < n) {
                answer[i] = sb.toString();
            } else {
                answer[i] = sb.substring(0, n);    
            }
            
            sb.replace(0, n, "");
        }
        
        
        return answer;
    }
}