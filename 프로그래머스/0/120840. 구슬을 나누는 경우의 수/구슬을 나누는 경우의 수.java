class Solution {
    public int solution(int balls, int share) {
        // balls 중 share개의 구슬을 고르는 경우의 수
        // 조합 ball C share 
        int answer = 0;
        
        answer = combination(balls, share);
        
        return answer;
    }
    
    public int combination(int n, int r) {
        // nCr = (n-1)C(r-1) + (n-1)Cr 공식 활용
        
        // nCn == nC0 == 1 
        if(n==r || r==0) {
            return 1;
        }
        
        return combination(n-1, r-1) + combination(n-1, r);        
    }
}