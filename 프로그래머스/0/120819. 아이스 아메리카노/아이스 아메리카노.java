class Solution {
    public int[] solution(int money) {
        int[] answer = new int[2];

        // 최대로 마실 수 있는 아메리카노 잔 수 
        answer[0] = money / 5500;
        // 남은 돈
        answer[1] = money - answer[0] * 5500;
        
        return answer;
    }
}