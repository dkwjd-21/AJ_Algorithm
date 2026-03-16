class Solution {
    public int[] solution(int num, int total) {
        // 연속된 수 num개를 더한 값이 total이 될 때,
        // 정수 배열을 오름차순으로 담아 리턴
        int[] answer = new int[num];
        
        // 첫번째 풀이 
        // x + (x+1) + (x+2) + ... + (x+num-1) = total  
        // num * x + (num-1)*num/2 = total 
        // -> x = (total - (num-1)*num/2) / num
        
        answer[0] = (total - (num-1)*num/2) / num;
        
        for(int i=1; i<answer.length; i++) {
            answer[i] = answer[0] + i;
        }
        
        return answer;
    }
}