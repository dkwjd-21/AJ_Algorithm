class Solution {
    public int solution(int order) {
        int answer = 0;
        int tmp;
        
        while(order != 0) {
            tmp = order % 10;
            if(tmp != 0 && tmp % 3 == 0) {
                answer++;
            }
            order = order / 10;            
        }
        
        return answer;
    }
}