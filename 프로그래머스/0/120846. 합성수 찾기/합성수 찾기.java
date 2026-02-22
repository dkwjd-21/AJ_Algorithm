class Solution {
    public int solution(int n) {
        // n 이하의 합성수의 개수 
        // 합성수 : 약수의 개수가 세 개 이상인 수 
        int answer = 0;
        
        for(int i=1; i<=n; i++) {
            boolean isPrime = true; 
            
            // i가 소수가 아닌 경우에만 카운트 증감
            for(int j=2; j*j<=i; j++) {
                if(i % j == 0) {
                    isPrime = false;
                    break;  
                }
            }
            
            if(!isPrime) answer++;
        }
        
        return answer;
    }
}