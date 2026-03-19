class Solution {
    public int solution(int number, int n, int m) {
        // number가 n의 배수이면서 m의 배수이면 1, 아니라면 0 리턴
        int answer = 0;
        
        if(number%n == 0 && number%m == 0) {
            answer = 1;
        }
        
        return answer;
    }
}