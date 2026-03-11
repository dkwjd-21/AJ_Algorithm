class Solution {
    public int solution(int a, int b) {
        // 두 정수 a와 b가 주어짐
        // a/b가 유한소수이면 1, 무한소수이면 2 
        // 유한소수의 조건 : 기약분수로 나타내었을 때, 분모의 소인수가 2와 5만 존재해야 함
        // 정수도 유한소수로 분류한다 
        int answer = 0;
        
        // 기약분수를 나타내기 위해서는 a와 b의 최대공약수를 알아야 함 
        int gcd = GCD(Math.max(a, b), Math.min(a, b));
        
        // 유한소수 확인
        int denominator = b/gcd;    
        
        // 분모에서 2를 소인수로 가지는 만큼 계속 나눈다
        while (denominator % 2 == 0) {
            denominator /= 2;
        }
        
        // 분모에서 5를 소인수로 가지는 만큼 계속 나눈다
        while (denominator % 5 == 0) {
            denominator /= 5;
        }

        // 소인수가 2와 5뿐이라면 남은 숫자가 1이어야 함
        answer = (denominator == 1) ? 1 : 2;
        return answer;
    }
    
    public int GCD(int x, int y) {
        // x > y 
        // 유클리드 호제법 
        if(x%y == 0) return y;
        return GCD(y, x%y);
    }
}