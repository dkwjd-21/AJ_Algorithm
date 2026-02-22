import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        // numbers 원소 중 두개를 곱해 만들 수 있는 최댓값을 리턴 
        int answer = 0;
        
        int len = numbers.length;
        Arrays.sort(numbers);
        answer = numbers[len-1] * numbers[len-2];
        
        return answer;
    }
}