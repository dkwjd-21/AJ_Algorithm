class Solution {
    static int answer;
    
    public int solution(int[] numbers, int target) {
        // numbers : 사용할 수 있는 숫자가 담긴 배열 (순서 바꾸지 않음)
        // target : 타겟 넘버 
        // 타겟 넘버를 만드는 경우의 수 return
        answer = 0;
        
        makeNum(0, 0, numbers, target);
        
        return answer;
    }
    
    // 숫자 만들기 (인덱스, 현재까지 만들어진 수, 숫자 배열, 타겟)
    public void makeNum(int idx, int current, int[] numbers, int target) {
        if(idx == numbers.length) {
            if(current == target) {
                answer++;
            }
            return;
        }
        
        // 덧셈 
        makeNum(idx+1, current+numbers[idx], numbers, target);
        // 뺄셈
        makeNum(idx+1, current-numbers[idx], numbers, target);
    }
}