class Solution {
    public long solution(int n) {
        // 끝에 도달하는 방법이 몇 가지인지 return (%1234567 해서) 
        long answer = 0;
        
        if(n<=2) return n;
        
        // i칸에 도달하는 방법 = i-1칸 도달방법 + i-2칸 도달방법
        //                   1칸 jump        2칸 jump
        int[] jump = new int[n+1];
        jump[1] = 1;        // 1번째 칸 경우의 수 : 1
        jump[2] = 2;        // 2번째 칸 경우의 수 : 1jump 2번, 2jump 1번
        
        for(int i=3; i<=n; i++) {
            jump[i] = (jump[i-1] + jump[i-2])%1234567;
        }
        
        answer = (long) jump[n];
        
        return answer;
    }
}