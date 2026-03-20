class Solution {
    public int solution(int n) {
        // n번째 피보나치 수를 1234567로 나눈 나머지를 리턴
        int[] f = new int[n+1];
        f[0] = 0; 
        f[1] = 1;
        
        for(int i=2; i<=n; i++) {
            f[i] = (f[i-1] + f[i-2])%1234567;
        }
        
        int answer = f[n];
        return answer;
    }
}