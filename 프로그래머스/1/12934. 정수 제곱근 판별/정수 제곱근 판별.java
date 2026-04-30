class Solution {
    public long solution(long n) {
        double root = Math.sqrt(n);
        
        long answer = 0;
        
        if(root%1 == 0) {
            // root가 정수라면
            long x = (long) root;
            answer = (x+1) * (x+1);
        } else {
            answer = -1;
        }
        
        
       
        
        
        
        return answer;
    }
}