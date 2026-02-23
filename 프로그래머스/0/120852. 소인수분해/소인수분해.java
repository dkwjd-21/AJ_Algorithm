import java.util.*;

class Solution {
    boolean[] isPrime;
    
    public ArrayList<Integer> solution(int n) {
        // n의 소인수를 오름차순으로 담은 배열을 리턴 
        // int[] answer = {};
        ArrayList<Integer> answer = new ArrayList<Integer>();
        
        // 소수 배열
        isPrime = new boolean[10001];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        
        primeChk(n);
        
        for(int i=2; i<=n; i++) {
            // i가 소수일 때만 n의 약수인지 확인
            if(isPrime[i] && n%i == 0) {
                answer.add(i);
            }
        }
        
        return answer;
    }
    
    public void primeChk(int n) {
        for(int i=2; i<=n; i++) {
            // 2부터 n까지 소수인지 아닌지 체크 
            if(isPrime[i]) {
                for(int j=2; i*j<=n; j++) {
                    isPrime[i*j] = false;
                }   
            }
        }
    }
    
}