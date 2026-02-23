class Solution {
    public int solution(int n) {
        int answer = 0;
        int[] factoArr = new int[11];
        
        for(int i=1; i<=10; i++) {
            factoArr[i] = factorial(i);
            if(factoArr[i] > n) {
                answer = i-1;
                break;
            } else if(factoArr[i] == n) {
                answer = i;
                break;
            }
        }
        
        return answer;
    }
    
    public int factorial(int n) {
        if(n==1) return 1;
        return n * factorial(n-1);
    }
}