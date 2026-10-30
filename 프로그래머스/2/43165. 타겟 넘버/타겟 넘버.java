class Solution {
    static int answer;
    
    public int solution(int[] numbers, int target) {
        // numbers : 사용할 수 있는 숫자 배열 (순서 바꾸지 않음)
        // numbers로 target을 만들 수 있는 경우의 수 return
        answer = 0;
        
        makeNumber(0, numbers, 0, target);
        
        return answer;
    }
    
    // 숫자 조합하기 (현재 만든 수, 숫자 배열, 이번에 사용할 숫자의 인덱스, 타겟) 
    public void makeNumber(int current, int[] numbers, int idx, int target) {
        if(idx == numbers.length) {
            if(current == target) {
                answer++;    
            }
            return;
        }
        
        // 덧셈을 하는 경우
        makeNumber(current+numbers[idx], numbers, idx+1, target);
        // 뺄셈을 하는 경우
        makeNumber(current-numbers[idx], numbers, idx+1, target);
    }
}