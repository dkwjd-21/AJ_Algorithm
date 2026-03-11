class Solution {
    public int solution(int[][] dots) {
        // 두 직선이 평행이 되는 경우가 있으면 1, 없으면 0 리턴
        int answer = 0;
        
        // 0번 1번 직선 & 2번 3번 직선
        if(slope(dots[0], dots[1]) == slope(dots[2], dots[3])) {
            return answer = 1;
        }
        
        // 0번 2번 직선 & 1번 3번 직선
        if(slope(dots[0], dots[2]) == slope(dots[1], dots[3])) {
            return answer = 1;
        }
        
        // 0번 3번 직선 & 1번 2번 직선
        if(slope(dots[0], dots[3]) == slope(dots[1], dots[2])) {
            return answer = 1;
        }
        
        return answer;
    }
    
    // 직선의 기울기를 구하는 메소드
    public double slope(int[] dot1, int[] dot2) {
        return (double)(dot1[1] - dot2[1]) / (dot1[0] - dot2[0]);
    }
}