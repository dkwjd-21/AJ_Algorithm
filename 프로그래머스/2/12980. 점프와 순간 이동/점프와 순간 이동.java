import java.util.*;

public class Solution {
    public int solution(int n) {
        // K칸 점프        or (현재까지 거리)x2로 순간이동
        // K 건전지 사용       건전지 사용 X
        // n만큼 떨어진 장소로 건전지를 최소로 사용해서 이동하기
        // 건전지 사용량의 최솟값 return
        int ans = 0;
        
        // n ~> 0 역으로 계산하는 방법
        while(n != 0) {
            if(n%2 == 0) {
                // n이 짝수라면 n/2에서 순간이동해온 것이다
                // 건전지 사용하지 않음
                n /= 2;
            } else {
                // n이 홀수라면 n-1에서 한 칸 이동한 것이다
                // 건전지 1 사용
                n -= 1;
                ans++;
            }
        }
        
        return ans;
    }
}

/*
동적 계획법으로 계산하려고 했으나 메모리초과, 시간초과 발생

// 각 칸별 건전지 사용량 최솟값 배열 
        // n : 1이상 10억 이하의 자연수
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        // 0번째 칸과 1번째 칸 초기화
        dp[0] = 0;
        dp[1] = 1;
        
        for(int i=2; i<=n; i++) {
            // i번째 칸에 오는 방법
            for(int j=1; j<=i; j++) {
                // j번째 칸에서 순간이동 할 수 있는지 chk
                if(j*2 == i) {
                    // 순간이동 -> j칸의 건전지 사용량과 같음 
                    dp[i] = Math.min(dp[i], dp[j]);
                } else {
                    // j칸에서 i-j칸 이동해야함
                    dp[i] = Math.min(dp[i], dp[j]+(i-j));
                }
            }
        }
        
        ans = dp[n];
*/