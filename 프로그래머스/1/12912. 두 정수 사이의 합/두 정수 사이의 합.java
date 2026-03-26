class Solution {
    public long solution(int a, int b) {
        if(a == b) return a;
        long answer = 0;
        
        for(int i=Math.min(a, b); i<=Math.max(a, b); i++) {
            answer += i;
        }
        
        return answer;
    }
}