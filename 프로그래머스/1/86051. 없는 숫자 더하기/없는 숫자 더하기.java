class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        
        boolean[] hasNum = new boolean[10];
        for(int num : numbers) {
            hasNum[num] = true;
        }
        
        for(int i=0; i<10; i++) {
            if(!hasNum[i]) {
                answer += i;
            }
        }
        
        return answer;
    }
}