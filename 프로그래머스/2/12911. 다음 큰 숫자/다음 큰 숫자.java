class Solution {
    public int solution(int n) {
        // n을 2진수로 변환했을 때 1의 갯수
        String nToBinary = Integer.toBinaryString(n).replace("0", "");
        int nCnt = nToBinary.length();
            
        // n보다 큰 자연수부터 시작
        int answer = n+1;
        
        while(true) {
            // n보다 큰 자연수를 2진수로 변환했을 때 1의 갯수
            String largeNumBinary = Integer.toBinaryString(answer).replace("0", "");
            int newCnt = largeNumBinary.length();
            
            if(nCnt == newCnt) {
                return answer;
            }
            
            answer++;
        }
    }
}