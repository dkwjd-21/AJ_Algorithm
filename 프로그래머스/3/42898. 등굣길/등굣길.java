class Solution {
    public int solution(int m, int n, int[][] puddles) {
        // m*n 크기 격자모양의 길 
        // 집이 있는 곳 (1,1) -> map[1][1]
        // 학교가 있는 곳 (m,n) -> map[n][m]
        // puddles : 물이 잠긴 지역의 좌표 (i,j) -> map[j][i]
        
        // 집에서 학교까지 갈 수 있는 최단경로의 개수를 1,000,000,007로 나눈 나머지를 return 
        //                                   -> 나누는 이유 : 오버플로 방지
        int answer = 0;
        
        // n이 가로줄이므로 인덱스 지정할 때 주의
        int[][] map = new int[n+1][m+1];
        
        // 웅덩이 표시 
        for(int[] p : puddles) {
            map[p[1]][p[0]] = -1;
        }
        
        // 집 위치 
        map[1][1] = 1;
        
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=m; j++) {
                // 집이면 건너뜀
                if(i==1 && j==1) continue;
                // 웅덩이면 건너뜀
                if(map[i][j] == -1) {
                    map[i][j] = 0;
                    continue;
                }
                
                // 위쪽에서 현재 칸으로 오는 경로 수 더하기
                int top = (i>1)? map[i-1][j] : 0;
                // 왼쪽에서 현재 칸으로 오는 경로 수 더하기
                int left = (j>1)? map[i][j-1] : 0;
                
                map[i][j] += (top + left) % 1000000007;
            }
        }
        
        return map[n][m];
    }
}