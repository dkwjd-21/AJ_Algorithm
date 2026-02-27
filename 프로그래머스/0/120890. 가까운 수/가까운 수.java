class Solution {
    public int solution(int[] array, int n) {
        int answer = 0;
        int tmp = Integer.MAX_VALUE;
        
        for(int num : array) {
            if(Math.abs(n-num) < tmp) {
                answer = num;
                tmp = Math.abs(n-num);
            } else if(Math.abs(n-num) == tmp && answer > num) {
                answer = num;
            }
        }
        
        return answer;
    }
}