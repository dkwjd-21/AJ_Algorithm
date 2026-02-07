class Solution {
    public int solution(int slice, int n) {
        // slice : 피자 조각 수 
        // n : 피자를 먹는 사람의 수 
        // n명의 사람이 최소 한 조각 이상 피자를 먹으려면 최소 몇 판? 
        int answer = 0;
        
        answer = n/slice;
        if(n%slice != 0) answer++;
        
        return answer;
    }
}