class Solution {
    public int solution(int n, int t) {
        // 1시간에 두배만큼 증식하는 세균
        // n : 처음 세균의 마리수
        // t : 경과한 시간 
        int answer = n;
        
        for(int i=1; i<=t; i++) {
            answer *= 2;
        }
        
        return answer;
    }
}