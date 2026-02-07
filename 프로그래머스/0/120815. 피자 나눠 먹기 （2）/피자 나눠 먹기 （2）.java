class Solution {
    public int solution(int n) {
        // 6조각으로 잘린 피자를 n명이 남기지 않고 먹을 때
        // 최소 몇 판 시켜야 하는지 
        int answer = 0; 
        
        // 6과 n의 최소공배수 
        int LCM = 0;
        for(int i=Math.min(6, n); i<=6*n; i++) {
            if(i%6==0 && i%n==0) {
                LCM = i;
                break;
            }
        }
        
        // 최소공배수(총 피자 조각) / 6 = 피자 판 수
        answer = LCM/6;
        
        return answer;
    }
}