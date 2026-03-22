class Solution {
    public int solution(int[] arr) {
        int answer = arr[0];
        
        for(int i=1; i<arr.length; i++) {
            answer = lcm(answer, arr[i]);
        }
        
        return answer;
    }
    
    // 두 수의 최소공배수를 구하는 메서드
    public int lcm(int a, int b) {
        // 0이 아닌 경우에만 계산하도록 주의
        return (a * b) / gcd(a, b);
    }
    
    // 두 수의 최대공약수를 구하는 유클리드 호제법
    public int gcd(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}