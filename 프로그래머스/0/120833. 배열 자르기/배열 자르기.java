class Solution {
    public int[] solution(int[] numbers, int num1, int num2) {
        // numbers의 num1번째 인덱스부터 num2번째 인덱스까지 자른 정수 배열 리턴
        int newSize = num2 - num1 + 1;
        int[] answer = new int[newSize];
        
        int idx = 0;
        for(int i=num1; i<=num2; i++) {
            answer[idx] = numbers[i];
            idx++;
        }
        
        return answer;
    }
}