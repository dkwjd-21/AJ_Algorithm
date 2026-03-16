class Solution {
    public int solution(int[] common) {
        // 마지막 원소 다음으로 올 숫자 리턴 
        int n = common.length;
        int answer = common[n-1];
        
        // 등차수열인지 확인
        if((common[1]-common[0]) == (common[2]-common[1])) {
            int d = common[1]-common[0];
            answer += d;
        } else {
            // 등차수열이 아니면 무조건 등비수열임
            int r = common[1] / common[0];
            answer *= r;
        }

        return answer;
    }
}