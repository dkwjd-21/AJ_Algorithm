class Solution {
    public int[] solution(int n, int m) {
        // n의 최대공약수와 최소공배수를 반환
        int[] answer = new int[2];
        
        // 최대공약수는 두 수의 작은 값보다 클 수 없음. 
        int tmp = Math.min(n, m);
        for(int i=1; i<=tmp; i++) {
            if(n%i == 0 && m%i == 0) {
                answer[0] = Math.max(answer[0], i);
            }
        }
        
        // 최소공배수 = n*m / 최대공약수
        answer[1] = n*m / answer[0];
        
        return answer;
    }
}