class Solution {
    public int solution(int hp) {
        int answer = 0;
        
        //  장군개미 
        int tmp = hp/5;
        answer += tmp;
        hp -= tmp * 5;
        
        // 병정개미 
        tmp = hp/3; 
        answer += tmp; 
        hp -= tmp * 3;
        
        // 일개미 
        answer += hp; 
        
        
        return answer;
    }
}