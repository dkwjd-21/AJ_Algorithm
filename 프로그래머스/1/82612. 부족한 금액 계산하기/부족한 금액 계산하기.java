class Solution {
    public long solution(int price, int money, int count) {
        // 놀이기구 이용로 price
        // 처음 가지고 있던 금액 money
        // 놀이기구 이용 횟수 
        long answer = 0;
        
        for(int i=1; i<=count; i++) {
            answer = answer + price*i;
        }
        
        if(answer > money) {
            answer = answer - money;
        } else {
            answer = 0;
        }
       
        
        return answer;
    }
}