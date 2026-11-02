class Solution {
    public int solution(int left, int right) {
        // left ~ right 모든 수 중,
        // 약수의 개수가 짝수면 더하기
        //            홀수면 빼기  
        int answer = 0;
        
        for(int i=left; i<=right; i++) {
            int cnt = 0;
            
            for(int j=1; j*j<=i; j++) {
                if(i % j == 0) {
                    // i가 j의 약수
                    if(j*j == i) {
                        // j의 제곱수라면
                        cnt++;
                    } else {
                        // 그냥 약수라면 짝을 이룸
                        cnt += 2;
                    }
                }
            }
            
            // 약수의 개수 판단
            if(cnt%2 == 0) {
                answer += i;
            } else {
                answer -= i;
            }
        }
        
        return answer;
    }
}