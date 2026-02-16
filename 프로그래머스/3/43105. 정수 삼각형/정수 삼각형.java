class Solution {
    public int solution(int[][] triangle) {
        // 꼭대기 값은 고정 
        int answer = triangle[0][0];
        
        // 가장 바닥의 층보다 한칸 위부터 2번째 층까지 올라가며 계산 
        for(int i=triangle.length-2; i>0; i--) {
            for(int j=0; j<triangle[i].length; j++) {
                int tmp = triangle[i][j];   // 현재 칸의 값
                
                if(j==0) {
                    // 왼쪽 끝 칸 일때
                    tmp += Math.max(triangle[i+1][0], triangle[i+1][1]);
                        
                } else {
                    // 중간 칸, 가장 오른쪽 칸 일때
                    tmp += Math.max(triangle[i+1][j], triangle[i+1][j+1]);
                    
                }
                
                // 현재 칸의 값 갱신 
                triangle[i][j] = tmp;
            }
        }
        
        // (0,0) 칸 값에 두번째 줄의 칸 중 더 큰 값을 더하기
        answer += Math.max(triangle[1][0], triangle[1][1]);
        
        return answer;
    }
}